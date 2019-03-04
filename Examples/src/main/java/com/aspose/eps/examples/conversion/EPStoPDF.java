package com.aspose.eps.examples.conversion;

import com.aspose.eps.Ps2PdfConverter;
import com.aspose.eps.Ps2PdfConverterOptions;
import com.aspose.eps.PsConverterException;
import com.aspose.eps.java.examples.Utils;
import java.awt.*;
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
        // Initialize PostScript input stream
        FileInputStream psStream = new FileInputStream( dataDir + "input.ps");
        // Initialize PDF output stream
        FileOutputStream pdfStream = new FileOutputStream( dataDir + "EPStoPDF_out.pdf");
        // If you want to convert Postscript file despite of minor errors set this flag
        Boolean suppressErrors = true;
        Ps2PdfConverterOptions options = new Ps2PdfConverterOptions(psStream, pdfStream, suppressErrors);
        // Set page size
        options.setPageSize(new Dimension(595, 842));
        // If you want to add special folder where fonts are stored. Default fonts folder in OS is always included.
        //options.setFontsFolders(new String[] { "{FONT_FOLDER}" });
        try
        {
            Ps2PdfConverter converter = new Ps2PdfConverter();
            converter.convertToPdf(options);
        }
        finally
        {
            psStream.close();
            pdfStream.close();
        }
        //Review errors
        if (suppressErrors)
        {
            for (PsConverterException ex : options.getExceptions()) {
                System.out.println(ex.getMessage());
            }
        }
        //ExEnd:EPStoPDF
    }    
}
