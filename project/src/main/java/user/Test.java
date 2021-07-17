package user;

public class Test {

	public static void main(String[] args) {
		String tempPwd = "";
		for(int i = 0 ;i<3; i++) {
			tempPwd += (char)((Math.random()*26)+65);

			

	}
		System.out.println(tempPwd);
}
}
