public class HelloWorldWorldHello {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="Hello World";
		String[] word=str.split(" ");
		StringBuilder sb=new StringBuilder();
		sb.append(word[0]).append(" ").append(word[1]).append(" ")
		.append(word[1]).append(" ").append(word[0]);
		System.out.println(sb.toString());
		
//		String rev=sb.reverse().toString();
//		System.out.println(str+" "+rev);

	}

}
