package practice;

public class LibraryFine {

	public static void main(String[] args) {
		System.out.println(libraryFine(9,10,2016,6,8,2015));
    }
    public static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {
    	int yDiff = y1 - y2;
        int mDiff = m1 - m2;
        int dDiff = d1 - d2;
        if( yDiff == 0){
            if(mDiff == 0){
                if(dDiff == 0){
                	return 0;				//000||Same Day
                }else{
                	return dDiff*15;			//D00||Days
                }
            }else if(dDiff == 0){			
            	return mDiff * 500;			//0M0||Months
            }else{
            	return (mDiff * 500) + (dDiff * 15);	//0MD||Months and Days
            }
        }else if(yDiff > 0 && mDiff > 0){
            if(dDiff == 0){
            	return (yDiff * 10000) + (mDiff * 500);	//YM0||Years and Months
            }else{
            	return (yDiff * 10000) + (mDiff * 500) + (dDiff * 15); //YMD||Years Months Days
            }    
        }else if(yDiff > 0 && dDiff > 0){
        	return (yDiff * 10000) + (dDiff * 15);	//Y0D||Years and Days
        }else{
        	return yDiff * 10000;			//Y00||Years
        }
    }

}
