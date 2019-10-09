import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LetterAvg {
	private char m;
	private int capacity = 10;
	
	String[] listOfStations = new String[capacity];
	private int numStations = 0;
	String[] listOfSameStations = new String[capacity];
	
	public LetterAvg (char s) throws IOException {
		this.m = s;
		readFile();
	}
	public void readFile() throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader("Mesonet.txt"));
		String input = br.readLine();
		input = br.readLine();
		input = br.readLine();
		input = br.readLine();
	
		while (input != null)
		{
			input = input.trim();
			String[] columns = input.split(" ");
			addStationId(columns[0]);
			input = br.readLine();
		}
		br.close();
	}
	private void expandStationIDArray()
    {
        int newCapacity = capacity * 2;
        String[] temp = new String[newCapacity];
        //animals = new Animal[capacity];
        
        for(int i = 0; i < listOfStations.length; i++)
        {
            temp[i] = listOfStations[i];
        }
        listOfStations = temp;
        capacity  = newCapacity;
    }
	
	public void addStationId(String x)
    {
        if(numStations == capacity)
        {
            expandStationIDArray();
        }
        
        listOfStations[numStations]= x;
        numStations++;
    }
	public int numberOfStationWithLetterAvg() {
		
		int l = 0;
		for(int i = 0; i < numStations; i++) {
			if(listOfStations[i].charAt(0) == m) {
				listOfSameStations[l] = listOfStations[i];
				l++;
			}
		}
		return l;
		
	}
	

}
