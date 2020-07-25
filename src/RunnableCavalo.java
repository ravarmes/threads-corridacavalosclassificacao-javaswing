
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import java.util.Random;

public class RunnableCavalo implements Runnable {

    public JButton jButton;
    public String nome;
    public int posicao;
    public static int qtdCavalosChegaram = 0;
    public int prioridade = Thread.MIN_PRIORITY;

    // Implementar classificação de chegada dos cavalos.
    public RunnableCavalo(JButton v1, String v2) {
        jButton = v1;
        nome = v2;
    }

    @Override
    public void run() {
        Thread.currentThread().setPriority(prioridade);
        System.out.println(Thread.currentThread().getName() + " - Prioridade: " + Thread.currentThread().getPriority());
        // Implementar a movimentação do cavalo
        // somar 900 pontos ao bound.x
        // jButton.setBounds(jButton.getBounds().x + 1, jButton.getBounds().y, jButton.getBounds().width, jButton.getBounds().height);
        // Para melhor visualizar a movimentação dos cavalos, utilize sleep. Ainda sobre o sleep, trabalhe com um valor aleatório até 1000. Assim, em cada execução, um cavalo diferente vencerá.
        for (int i = 1; i <= 600; i++) {

            jButton.setBounds(jButton.getBounds().x + 1, jButton.getBounds().y, jButton.getBounds().width, jButton.getBounds().height);

            if (jButton.getBounds().x == 500) {
                System.out.println(Thread.currentThread().getName() + " - Chegou!!!");
                this.posicao = qtdCavalosChegaram + 1;
                qtdCavalosChegaram = qtdCavalosChegaram + 1;
            }

            sleep2();
        }

    }

    /*
        Este método tem a finalidade de deixar a corrida de cavalos mais lenta.
        A estratégia para isso é utilizar o método Thread.sleep
     */
    public void sleep1() {
        try {
            //Thread.sleep(new Random().nextInt(50));
            Thread.sleep(50); //Espera cronometrada
        } catch (InterruptedException ex) {

        }
    }

    /*
        Este método tem a finalidade de deixar a corrida de cavalos mais lenta.
        A estratégia para isso é a realização de um processamento (for e ifs)
     */
    public void sleep2() {
        int l = 0;
        for (int j = 1; j <= 4000000; j++) {
            if (l % 3 == 0) {
                l = l + 2;
            }
            if (l % 2 == 0) {
                l = l + 1;
            }
            l = l + 1;
        }
    }

}
