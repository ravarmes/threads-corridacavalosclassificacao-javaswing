
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;

public class RunnableClassificacao implements Runnable {

    public JList jList;
    RunnableCavalo[] runnablesCavalos;

    public RunnableClassificacao(JList v1, RunnableCavalo[] v2) {
        jList = v1;
        runnablesCavalos = v2;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());

        //Apenas quando os cinco cavalos tiverem ultrapassado a linha de chegada será exibida a classificação
        while (RunnableCavalo.qtdCavalosChegaram < 5) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {

            }
        }

        //Ordenando os runnableCavalos (Runnables) no vetor por ordem de chegada
        RunnableCavalo aux;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (runnablesCavalos[i].posicao < runnablesCavalos[j].posicao) {
                    aux = runnablesCavalos[i];
                    runnablesCavalos[i] = runnablesCavalos[j];
                    runnablesCavalos[j] = aux;
                }
            }
        }

        //Imprimindo no JList a classificação da corrida
        DefaultListModel modelo = new DefaultListModel();
        jList.setModel(modelo);

        for (int i = 0; i < 5; i++) {
            modelo.addElement(runnablesCavalos[i].nome);
        }
    }

}
