package evgenyt.springdemo;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;
import com.lowagie.text.Table;

/**
 * PDF file generation
 */

public class PfdReport extends AbstractPdfView {
    @Override
    protected void buildPdfDocument(Map<String, Object> map,
        com.lowagie.text.Document document,
        com.lowagie.text.pdf.PdfWriter pdfWriter,
        HttpServletRequest httpServletRequest,
        HttpServletResponse httpServletResponse)
    throws Exception {
        // Get data controller passed
        List<String> dataList = (List<String>) map.get("testList");
        // Header
        Table table = new Table(1);
        table.addCell("col1");
        // Add data to pdf-table
        for (String data : dataList)
            table.addCell(data);
        // Add pdf-table to pdf document
        document.add(table);
    }
}
