package org.study.processamentoplanilhas.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.study.processamentoplanilhas.domain.CarroSpreadsheet;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Slf4j
@Service
public class ProcessSpreadsheetService {

    public List<CarroSpreadsheet> processExcelFile(MultipartFile file) throws IOException {
        List<CarroSpreadsheet> dtos = new ArrayList<>();

        try (InputStream is = file.getInputStream()) {
            Workbook workbook = WorkbookFactory.create(is);
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            boolean isFirstRow = true;

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();

                if (isFirstRow) {
                    isFirstRow = false; // Skip header row
                    continue;
                }


                // Pega valores da planilha, na linha
                final String data = getStringCellValue(row.getCell(0));
                final String abastecido = getStringCellValue(row.getCell(1));
                final String hodometro = getStringCellValue(row.getCell(2));
                final String preco = getStringCellValue(row.getCell(3));

                // Valida se a linha ta preenchida
                final boolean hasAbastecimento = abastecido != null && !abastecido.isBlank();
                final boolean hasData = data != null && !data.isBlank();
                final boolean hasHodometro = hodometro != null && !hodometro.isBlank();
                final boolean hasPreco = preco != null && !preco.isBlank();

                // Setas os valores da LINHA em um objeto
                if (hasAbastecimento || hasData || hasHodometro || hasPreco) {
                    CarroSpreadsheet dto = new CarroSpreadsheet();
                    dto.setData(data);
                    dto.setAbastecido(abastecido);
                    dto.setHodometro(hodometro);
                    dto.setPreco(preco);
                    dtos.add(dto);
                }
            }
        }

        return dtos;
    }

    private String getStringCellValue(Cell cell) {
        if (cell == null) {
            return null;
        }
        return cell.getCellType() == CellType.STRING ? cell.getStringCellValue() : cell.toString();
    }

}
