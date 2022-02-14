package com.eea.v2.service.general;

import com.eea.v2.ApplicationResource;
import org.apache.commons.collections4.IteratorUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class PEMemberFileDataFormatChecker {
    private static boolean checkRecord(List<Cell> cells){
        System.out.println(cells);
       boolean result = cells.get(0).toString().trim().length()!=0
               && ApplicationResource.VALID_EMAIL_ADDRESS_REGEX.matcher(cells.get(1).toString()).find()
               && cells.get(2).toString().length()==10
               && cells.get(3).toString().trim().length()!=0
               && cells.get(4).toString().trim().length()!=0
               && cells.get(5).toString().trim().length()!=0;
       return true;
    }
    public static HashMap<String,Integer> checkFileFormat(MultipartFile file){
        HashMap<String,Integer> ret = new HashMap<>();
        try {
            int correct = 0;
            int wrong = 0;
           Workbook workbook = new XSSFWorkbook(file.getInputStream());
            Sheet sheet = workbook.getSheet("Sheet1");
            Iterator<Row> rowIterator = sheet.rowIterator();
            Row r = rowIterator.next();
            Iterator<Cell> cellIterator=r.cellIterator();
            List<Cell> cells = IteratorUtils.toList(cellIterator);
            if(cells.toString().equals(ApplicationResource.PE_FILE_HEADERS.toString())){
                System.out.println("Headers OK");
                while (rowIterator.hasNext()){
                    r = rowIterator.next();
                    cellIterator = r.cellIterator();
                    cells = IteratorUtils.toList(cellIterator);
                    if(checkRecord(cells)) correct++;
                    else wrong++;
                }
                ret.put("Correct",correct);
                ret.put("Wrong",wrong);
                return ret;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ret;
    }
}
