import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class PosAvg {
	
	private int capacity = 10;
	
	String[] listOfStations = new String[capacity];
	
	private String id;
	
	private int numStations = 0;
	
	public PosAvg (String a) throws IOException {
		this.id = a;
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
	public int indexOfStation() {
		int b = 0;
		for (int i = 0; i < listOfStations.length; i++)
		{
			if (id.equalsIgnoreCase(listOfStations[i]))
			{
				b = i;
			}
		}
		return b + 1;
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
	
	public String[] findSameAvgStations()
	{
		String[] result = new String[4];
		int index = indexOfStation() - 1;
		result[0] = listOfStations[index - 1];
		result[1] = listOfStations[index + 1];
		result[2] = listOfStations[index - 2];
		result[3] = listOfStations[index + 2];
		
		return result;
	}
	public String toString() {
		String[] idNames = findSameAvgStations();
		String result = "This index is average of " + idNames[0] + " and " + idNames[1] + ", " + idNames[2] + " and " + idNames[3] + ", and so on.";
		return result;
	}
	
	
	

}
