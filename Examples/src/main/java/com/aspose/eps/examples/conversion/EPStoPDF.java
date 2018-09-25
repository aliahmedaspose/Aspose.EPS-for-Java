import com.aspose.eps.Ps2PdfConverter;
import com.aspose.eps.Ps2PdfConverterException;
import com.aspose.eps.Ps2PdfConverterOptions;
import com.aspose.eps.java.examples.Utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class EPStoPDF {
    /**
     * The main entry point for the application.
     */
    public static void main(String[] args) throws Exception
    {
        //ExStart:EPStoPDF
        // The path to the documents directory.
        String dataDir = Utils.getDataDir();
       
        try {
        Ps2PdfConverter converter = new Ps2PdfConverter();
        FileInputStream fis = new FileInputStream( dataDir + "input.ps");
        FileOutputStream fos = new FileOutputStream( dataDir + "EPStoPDF_out.pdf");
        Ps2PdfConverterOptions options = new Ps2PdfConverterOptions(fis, fos, true);
        options.setDebug(true);
        converter.convertToPdf(options);

        for (int i = 0; i < options.getExceptions().size(); i++) {
        Ps2PdfConverterException ex = (Ps2PdfConverterException) options.getExceptions().get(i);
        System.out.println(ex.getStackTrace());
        }

        } catch (Exception ex) {
        throw new RuntimeException(ex);
        }
        //ExEnd:EPStoPDF
    }    
}
