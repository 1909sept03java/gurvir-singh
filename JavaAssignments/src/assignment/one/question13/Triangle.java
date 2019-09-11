package assignment.one.question13;

public class Triangle {
	
	public void makeTri(int n) { //I made n the number of levels the triangle will have.
		
		int x = 0;
		for(int i = 0; i < n; i ++) {
			for(int j = 0; j <= i; j++) {
				System.out.print(x);
				if(x == 0)
					x = 1;
				else 
					x = 0;
				
			}
			System.out.println();
			
		}
		
	}
	
	public static void main(String[] args) {
		
		Triangle t = new Triangle();
		t.makeTri(4);
	}

}
