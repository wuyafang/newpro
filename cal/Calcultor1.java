package calcultor1;
import java.util.Scanner;
import java.util.Stack;
import java.lang.*;

public class Calcultor1 {
	private Stack<String> postfixStack=new Stack<String>();//后缀表达式栈
	private Stack<Character> OPStack=new Stack<Character>();//运算符栈
	private Stack<String> reverseStack=new Stack<String>();//反转后缀
	private Stack<String> operatorStack=new Stack<String>();//操作数后缀

	public static void main(String[] args) {
		 Calcultor1 expr  = new Calcultor1();
		 for(int i=0;i<2;i++){
		 Scanner in =new Scanner(System.in);
		 String s = in.next();
		 //expr.MidToPost(s);
		 int result  = expr.calculate(s);
		 System.out.println(result);
		 }
	 }
	//规定优先级
	public int checkPriority(Character op)
	{
		switch(op)
		{
		case'+':
			return 1;
		case'-':
			return 1;
		case'*':
			return 2;
		case'/':
			return 2;
		case'%':
			return 3;
		case'(':
			return 0;
		}
		return -1;
	}
	//检查是否是运算码
	public boolean checkOP(Character op)
	{
		if(op=='+'||op=='-'||op=='*'||op=='/'||op=='%'||op=='('||op==')')
			return true;
		else
			return false;
	}
	//检查是否是数字
	public boolean checkInt(Character m)
	{
		if((m>='0')&&(m<='9')){
		//	System.out.println("it is a number");
			return true;
		}
		else
			return false;
	}
	//转化成后缀表达式
	public void MidToPost(String expression)
	{
		char[] exp=expression.toCharArray();
		int i=0;
		int currentprio=-1;
		
		
		while(i<exp.length)
		{
			if(checkInt(exp[i])){
				char[] number=new char[100];
				int j=0;
				while(i<exp.length&&checkInt(exp[i]))//数字
				{
					number[j++]=exp[i++];
					//System.out.println(i+"="+exp[i++]);
				}
				String s=new String(number);
				//System.out.println(s);
				postfixStack.push(s);
			}
			if(i<exp.length&&checkOP(exp[i]))//运算符
			{
				if(exp[i]==')')
				{
					while(OPStack.peek()!='(')
						postfixStack.push(String.valueOf(OPStack.pop()));
					OPStack.pop();
				}
				else if(OPStack.empty()||exp[i]=='(')
				{
					OPStack.push(exp[i]);
					//System.out.println(i+"="+exp[i]);
				}
				else
				{
				
					while(!OPStack.empty()&&checkPriority(exp[i])<=checkPriority(OPStack.peek()))
					{
						postfixStack.push(String.valueOf(OPStack.pop()));
					}
					OPStack.push(exp[i]);
					//System.out.println(i+"="+exp[i]);
				}
				
			}
			else{
				break;
			}
			i++;
		}
		//System.out.println("SUCCESS");
		while(!OPStack.empty())
		{
			postfixStack.push(String.valueOf(OPStack.pop()));
		}
		/*while(!postfixStack.empty())
		System.out.println(postfixStack.pop());*/
	}
	public void reverse()
	{
		while(!postfixStack.empty())
		reverseStack.push(postfixStack.pop());
	}
	public String math(String first,String m,String second)
	{
		int result=2;
		Character x=m.charAt(0);
		switch(x)
		{
		case'+':
			result=Integer.parseInt(first.trim())+Integer.parseInt(second.trim());
			break;
		case'-':
			result=Integer.parseInt(first.trim())-Integer.parseInt(second.trim());
			break;
		case'*':
			result=Integer.parseInt(first.trim())*Integer.parseInt(second.trim());
			break;
		case'/':
			result=Integer.parseInt(first.trim())/Integer.parseInt(second.trim());
			break;
		case'%':
			result=Integer.parseInt(first.trim())%Integer.parseInt(second.trim());
			break;
		default:
			break;
		}
		//System.out.println("result="+result);
		return 	String.valueOf(result);
	}

	//计算后缀表达式的值
	public int calculate(String expression)
	{
		MidToPost(expression);
		int result=1;
		reverse();
		String first,second,x;
		while(!reverseStack.empty())
		{
			x=reverseStack.pop();
			
			if(checkOP(x.charAt(0)))//转化成char:操作符
			{
				second=operatorStack.pop();
				first=operatorStack.pop();
				//System.out.println(first+x+second);
				operatorStack.push(math(first,x,second));
				
				//System.out.println(operatorStack.peek());
				
			}
			else                      //数字
				operatorStack.push(x);
		}
		if(!operatorStack.empty())
		result=Integer.parseInt(operatorStack.pop());   //int 转化成String
		return result;
	}
	
	

}
