package stock.stockmanagement;

import java.io.*;

/**
 * Class to define the file that saves the portfolio
 * @author hectorpascualmarin
 * @version 1.0
 */
public class File {
    private static String file;

    public File(){
        file = "stocks.txt";
    }

    private static Stock createStock(String[] datos){
        double purchasePrice = Double.parseDouble(datos[2]);
        double quantity = Double.parseDouble(datos[3]);
        double actualPrice = Double.parseDouble(datos[4]);
        double dividend = Double.parseDouble(datos[8]);
        Stock stock = new Stock(datos[0], datos[1], purchasePrice, quantity,
                actualPrice, datos[5], datos[6], datos[7], dividend);
        return stock;
    }

    public static void readFile(Portfolio portfolio){
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while((line = br.readLine()) != null){
                portfolio.addStock(createStock(line.split(";")));
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static void saveFile(Portfolio portfolio){
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            for(Stock s : portfolio.getStockList()){
                bw.write(s.getName() + ";" + s.getTicker() + ";" + s.getPurchasePrice() + ";" +
                        s.getQuantity() + ";" + s.getActualPrice() + ";" + s.getCountry() + ";" +
                        s.getSector() + ";" + s.getCurrency() + ";" + s.getDividend() + "\n");
            }
            bw.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
