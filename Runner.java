package VelSir;

public class Runner {
    public static void main(String[] args) throws InterruptedException {
        Operation operation = new Demoqa();
        operation.openBrowser();
        operation.getAllLinks();
        operation.confirmDialogBox();
        operation.cancelDialogBox();
        operation.getLinkCount();
        operation.closeBrowser();
    }
}
