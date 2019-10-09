
public class MesoInherit extends MesoAbstract {
	
	private MesoStation stationID;
	
	public MesoInherit (MesoStation a) {
		stationID = a;
	}

	@Override
	int[] calAverage() {
		// TODO Auto-generated method stub
		int[] x = new int[3];
		int a = (int) stationID.getStID().charAt(0);
		int b = (int) stationID.getStID().charAt(1);
		int c = (int) stationID.getStID().charAt(2);
		int d = (int) stationID.getStID().charAt(3);
		int total = a + b + c + d;
		double sum = (double) total;
		double average = sum / 4;
		
		x[0] = (int) Math.ceil(average);
		x[1] = (int) Math.floor(average);
		if (average - x[1] >= 0.5) {
			x[2] = (int) Math.ceil(average);
		}
		else {
			x[2] = (int) Math.floor(average);
		}
		
		
		return x;
	}

	@Override
	char letterAvg() {
		// TODO Auto-generated method stub
		char q;
		int[] o = calAverage();
		q = (char) o[2];
		
		
		return q;
	}

}
