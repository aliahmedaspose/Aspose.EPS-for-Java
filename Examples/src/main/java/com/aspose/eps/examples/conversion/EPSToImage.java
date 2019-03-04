package com.aspose.eps.examples.conversion;

import com.aspose.eps.*;
import com.aspose.eps.java.examples.Utils;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class EPSToImage {
    public static void main(String[] args) throws Exception
    {
        //ExStart:EPSToImage
        // The path to the documents directory.
        String dataDir = Utils.getDataDir();
        // Initialize PostScript input stream
        FileInputStream psStream = new FileInputStream( dataDir + "input.ps");
        // If you want to convert Postscript file despite of minor errors set this flag
        Boolean suppressErrors = true;
        //Initialize options object with necessary parameters. Default image format is PNG and it is not required to set it in Ps2ApsConverterOptions.
        ImageFormat imageFormat = ImageFormat.PNG;
        Ps2ApsConverterOptions options = new Ps2ApsConverterOptions(psStream, suppressErrors);

        //If you want to obtain images in another format, uncomment following lines
        //imageFormat = com.aspose.eps.ImageFormat.Jpeg;
        //options = new Ps2ApsConverterOptions(psStream, suppressErrors, imageFormat);

        // Set page size. This size will be also the size of resulting images.
        options.setPageSize(new Dimension(595, 842));
        // If you want to add special folder where fonts are stored. Default fonts folder in OS is always included.
        //options.setFontsFolders(new String[] { "{FONT_FOLDER}" });

        Ps2ApsConverter converter = new Ps2ApsConverter();
        try
        {
            //Because PS file can contain several pages for every page an image bytes array will be obtained. //The number of bytes arrays equals to the number of pages in input PS file.
            byte [][] imagesBytes = converter.convertToImages(options);
            int i = 0;

            for (byte [] imageBytes : imagesBytes)
            {
                String imagePath = "out_image" + i + "." + imageFormat.toString().toLowerCase();

                FileOutputStream fs = new FileOutputStream(dataDir + imagePath);
                fs.write(imageBytes, 0, imageBytes.length);
                i++;
            }
        }
        finally
        {
            psStream.close();
        }
        //Review errors
        if (suppressErrors)
        {
            for (PsConverterException ex : options.getExceptions()) {
                System.out.println(ex.getMessage());
            }
        }
        //ExEnd:EPSToImage
    }
}
