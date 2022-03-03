import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Product {
    private static Scanner scan = new Scanner(System.in);
    //String str = scan.nextLine();
    private static final int product_size = 5;
    private static final ArrayList<String> product = new ArrayList();

    public static void addProduct () {
        if (product.size() == product_size) {
            System.out.println("----------------------------------------------");
            System.out.println("| Склад полон, больше ничего нельзя добавить |");
            System.out.println("----------------------------------------------");
            System.out.println("");
        } else {
            System.out.print("Введите наименование товара: ");
            String prodadd = scan.nextLine();
            product.add(prodadd);
            System.out.println("--------------------------");
            System.out.println("| Товар успешно добавлен |");
            System.out.println("--------------------------");
            System.out.println("");
        }
    }

    public static void delProduct () {
        if (product.size() == 0) {
            System.out.println("-------------------------------------");
            System.out.println("| Склад пуст, ничего удалить нельзя |");
            System.out.println("-------------------------------------");
            System.out.println("");
        }
        else {
            System.out.print("Какой товар удалить?: ");
            String proddel = scan.nextLine();
            if (product.contains(proddel)) {
                product.remove(proddel);
                System.out.println("------------------------");
                System.out.println("| Товар успешно удален |");
                System.out.println("------------------------");
                System.out.println("");
            } else {
                System.out.println("-------------------------------");
                System.out.println("| Такого товара на складе нет |");
                System.out.println("-------------------------------");
                System.out.println("");
            }
        }
    }

    public static void viewProduct () {
        if (product.size() == 0) {
            System.out.println("--------------");
            System.out.println("| Склад пуст |");
            System.out.println("--------------");
            System.out.println("");
        } else {
            System.out.println("Склад " + product);
            System.out.println("");
        }
    }

    public static void exportProduct () {
        HSSFWorkbook book = new HSSFWorkbook();
        HSSFSheet sheet = book.createSheet("Warehouse");
        HSSFRow row_title = sheet.createRow(0);
        HSSFCell cell_title = row_title.createCell(1);
        cell_title.setCellValue("Товар");
        HSSFCellStyle style = book.createCellStyle();
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        style.setBorderTop(BorderStyle.THIN);

        int rowCount = 0;
        for (Object item : product) {
            Row row = sheet.createRow(++rowCount);
            Cell cell = row.createCell(1);
            cell.setCellStyle(style);
            cell.setCellValue((String) item);
        }
        try (FileOutputStream outputStream = new FileOutputStream("Warehouse.xls")) {
            book.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("--------------------------------------------------------");
        System.out.println("| Экспорт склада в файл Warehouse.xls успешно завершен |");
        System.out.println("--------------------------------------------------------");
        System.out.println("");
    }
}
