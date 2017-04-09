
import java.util.Random;


public class Dice extends javax.swing.JFrame 
{
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;

    /**
     * Creates new form Dice
     */
    public Dice() 
    {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() 
    {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Die");

        jButton1.setText("Roll");
        jButton1.addActionListener(new java.awt.event.ActionListener() 
        {
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
            .addGroup(layout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) 
    {

        int ranNum = (int)(Math.random() * 6) + 1;
        
        
        switch(ranNum)
        {
            case 1:
                 jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("\\image_assets\\purple.png")));
                break;
            case 2:
                jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("\\image_assets\\yellow.png")));
                break;
            case 3:
                jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("\\image_assets\\red.png")));
                break;
            case 4:
                jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("\\image_assets\\blue.png")));
                break;    
            case 5:
                jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("\\image_assets\\green.png")));
                break;
            case 6:
                jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("\\image_assets\\purple.png")));
                break;
        }
    }
}
