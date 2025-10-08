import java.util.*;
public class DSA_sheets {
    
    public static void trapedRainWater(int height[]){
        //leftHighestHeight
        int lhh[]= new int[height.length];
        lhh[0]=height[0];
        for(int i=1; i<=(height.length-1); i++){
            lhh[i]=Math.max(lhh[i-1],height[i]);
            
        }
        
        //rightHighestHeight
        int rhh[]= new int[height.length];
        rhh[height.length-1]=height[height.length-1];
        for(int i=(height.length-2); i>=0; i--){
            rhh[i]=Math.max(rhh[i+1],height[i]);
        }
        
        int trapedWater=0;
        int waterLevel=0;
        for(int i=0; i<=(height.length-1); i++){
            waterLevel=Math.min(lhh[i],rhh[i]);
            trapedWater+=waterLevel-height[i];
        }
        System.out.printf("Trapped Water is %d",trapedWater);
    }
    
    public static String buyAndSellStocks(int stocks[]){
        int maxProfit=0;
        int buyingPrice=Integer.MAX_VALUE;
        int buyingDay=0,sellingDay=0;
        
        for(int i=0; i<=(stocks.length-1); i++){
            if(buyingPrice>=stocks[i]){
                buyingPrice=stocks[i];
                buyingDay=i+1;
            } 
            
            int profit=stocks[i]-buyingPrice;
            if(profit>=maxProfit){
                maxProfit=profit;
                sellingDay=i+1;
            }
        }
        if(maxProfit>0){
            return "Total profit is "+maxProfit+" from day "+buyingDay+" to "+sellingDay;
        }else{
            return "Profit is"+maxProfit;
        }
    } 
    
    
    public static void main(String[] args) {
        int arr[]={7,1,5,3,6,4};
        //trapedRainWater(arr);
        System.out.print(buyAndSellStocks(arr));
    }
    
}