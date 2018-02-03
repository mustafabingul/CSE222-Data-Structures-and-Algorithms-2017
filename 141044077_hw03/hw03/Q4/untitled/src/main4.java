import javax.swing.plaf.synth.SynthEditorPaneUI;

public class main4 {

    public static void main(String args[]){


        SingleLinkedList lst = new SingleLinkedList();


        for (int i=0; i<100;++i)
        {
            lst.add(i);
        }
        for (int i=0; i<50;++i)
        {
            lst.delete(i);
        }
        for (int i=100; i<200;++i)
        {
            lst.add(i);
        }

        lst.deletedToString();
        System.out.println(lst.toString());
    }



}
