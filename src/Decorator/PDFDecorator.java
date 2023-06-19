/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Decorator;

/**
 *
 * @author Ber
 */
public abstract class PDFDecorator implements PDFGenerator{
    
    protected PDFGenerator pdfGenerator;

    public PDFDecorator(PDFGenerator pdfGenerator) {
        this.pdfGenerator = pdfGenerator;
    }

    @Override
    public void generarFacturaPDF() {
        pdfGenerator.generarFacturaPDF();
    }
    
}
