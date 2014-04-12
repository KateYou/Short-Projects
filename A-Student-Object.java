//********************************************************************
//  Student.java       Author: Lewis/Loftus
//
//  Represents a college student.
//********************************************************************

public class Student
{
   private String firstName, lastName;
   private Address homeAddress, schoolAddress;
	private int test1, test2, test3;
	int testNum = 0, score = 0;
	double avg = 0;
	int getScore = 0;

   //-----------------------------------------------------------------
   //  Constructor: Sets up this student with test scores set to zero.
   //-----------------------------------------------------------------
   public Student (String first, String last, Address home,
                   Address school)
   {
      firstName = first;
      lastName = last;
      homeAddress = home;
      schoolAddress = school;
		test1 = 0;
		test2 = 0;
		test3 = 0;
   }
	

   //-----------------------------------------------------------------
   //  Overloaded Constructor: Sets up this student with test scores passed in.
   //-----------------------------------------------------------------
   public Student (String first, String last, Address home,
                   Address school, int test1, int test2, int test3)
   {
      firstName = first;
      lastName = last;
      homeAddress = home;
      schoolAddress = school;
		this.test1 = test1;
		this.test2 = test2;
		this.test3 = test3;
   }
	
	public void setTestScore (int testNum, int score)
	{
		switch (testNum)
		{
			case 1:
			test1 = score;
			break;
			case 2:
			test2 = score;
			break;
			case 3:
			test3 = score;
			break;
			default:
			System.out.println ("Invalid test number");
		}	
	}
	
	public int getTestScore(int testNum)
	{
		switch (testNum)
		{
			case 1:
			getScore = test1;
			break;
			case 2:
			getScore = test2;
			break;
			case 3:
			getScore = test3;
			break;
			default:
		}	
		return getScore;
	}	

	public double average()
	{
		avg = (test1 + test2 + test3)/3;
		return avg;
	}
	
	
   //-----------------------------------------------------------------
   //  Returns a string description of this Student object.
   //-----------------------------------------------------------------
   public String toString()
   {
      String result;

      result = firstName + " " + lastName + "\n";
      result += "Home Address:\n" + homeAddress + "\n";
      result += "School Address:\n" + schoolAddress + "\n";
		result += "Test score one was: " + test1 + "\n";
		result += "Test score two was: " + test2 + "\n";
		result += "Test score three was: " + test3 + "\n";
		result += "Average test scores were: " + average();
      return result;
   }
}
