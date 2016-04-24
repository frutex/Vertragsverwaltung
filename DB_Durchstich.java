package GUI;

import java.awt.BorderLayout;

public class DB_Durchstich extends JFrame {

	private JTextField txtName;
	private JTextField txtVorname;
	private JTextField txtTelNr;
	private JTextField txtAdresse;
	private JTextField txtID;
	private JTextField txtNameS;
	private Session session;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DB_Durchstich frame = new DB_Durchstich();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DB_Durchstich() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		SessionFactory sessionFactory = new Configuration().configure("/hibernate.cfg.xml").buildSessionFactory();
		session = sessionFactory.openSession();

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblTesteingabemaske = new JLabel("Testeingabemaske");
		lblTesteingabemaske.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTesteingabemaske.setBounds(146, 11, 200, 48);
		panel.add(lblTesteingabemaske);

		JLabel lblNeuerMitarbeiter = new JLabel("Neuer Mitarbeiter");
		lblNeuerMitarbeiter.setBounds(10, 82, 127, 14);
		panel.add(lblNeuerMitarbeiter);

		JLabel lblName = new JLabel("Name");
		lblName.setBounds(10, 123, 80, 14);
		panel.add(lblName);

		JLabel lblVorname = new JLabel("Vorname");
		lblVorname.setBounds(10, 146, 80, 14);
		panel.add(lblVorname);

		JLabel lblTelnr = new JLabel("TelNr");
		lblTelnr.setBounds(10, 171, 80, 14);
		panel.add(lblTelnr);

		JLabel lblAdresse = new JLabel("Adresse");
		lblAdresse.setBounds(10, 196, 80, 14);
		panel.add(lblAdresse);

		txtName = new JTextField();
		txtName.setBounds(101, 120, 106, 20);
		panel.add(txtName);
		txtName.setColumns(10);

		txtVorname = new JTextField();
		txtVorname.setColumns(10);
		txtVorname.setBounds(100, 143, 107, 20);
		panel.add(txtVorname);

		txtTelNr = new JTextField();
		txtTelNr.setColumns(10);
		txtTelNr.setBounds(100, 168, 107, 20);
		panel.add(txtTelNr);

		txtAdresse = new JTextField();
		txtAdresse.setColumns(10);
		txtAdresse.setBounds(100, 193, 107, 20);
		panel.add(txtAdresse);

		JLabel lblSucheMitarbeiter = new JLabel("Suche Mitarbeiter");
		lblSucheMitarbeiter.setBounds(281, 82, 119, 14);
		panel.add(lblSucheMitarbeiter);

		JLabel lblId = new JLabel("ID");
		lblId.setBounds(281, 123, 46, 14);
		panel.add(lblId);

		JLabel lblName_1 = new JLabel("Name");
		lblName_1.setBounds(281, 146, 46, 14);
		panel.add(lblName_1);

		txtID = new JTextField();
		txtID.setBounds(337, 120, 86, 20);
		panel.add(txtID);
		txtID.setColumns(10);

		txtNameS = new JTextField();
		txtNameS.setColumns(10);
		txtNameS.setBounds(337, 143, 86, 20);
		panel.add(txtNameS);

		JButton btnSuche = new JButton("Suche");
		btnSuche.setBounds(281, 225, 119, 23);
		btnSuche.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int id;
				if(txtID.getText().equals("")){
					id=0;
				}else{
					id=Integer.parseInt(txtID.getText());
				}
				MitarbeiterEO tmp = findMA(session, id, txtNameS.getText());
				txtName.setText(tmp.getM_name());
				txtVorname.setText(tmp.getM_vorname());
				txtTelNr.setText(tmp.getM_telnr());
				txtAdresse.setText(tmp.getM_adresse());
				txtID.setText(Integer.toString(tmp.getM_id()));
			}

		});
		panel.add(btnSuche);

		JButton btnHinzufgen = new JButton("Hinzuf\u00FCgen");
		btnHinzufgen.setBounds(44, 225, 119, 23);
		btnHinzufgen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int ID = storeMA(session, txtName.getText(), txtVorname.getText(), txtTelNr.getText(),
						txtAdresse.getText());
				txtID.setText(Integer.toString(ID));
			}

		});
		panel.add(btnHinzufgen);

	}

	public MitarbeiterEO findMA(Session session, int id, String name) {
		if (id != 0) {
			return (MitarbeiterEO) session.get(MitarbeiterEO.class, new Integer(id));
		} else {
			String hql="FROM "+MitarbeiterEO.class.getName()+" WHERE M_NAME = :name";
			Transaction tx;
			tx = session.beginTransaction();
			try {
				MitarbeiterEO tmp= (MitarbeiterEO) session
						.createQuery(hql).setParameter("name", name).list().get(0);
				tx.commit();
				return tmp;
			} catch (Exception e) {
				if (tx != null)
					tx.rollback();
				throw e;
			} finally {
			}
			
			
		}
	}

	@SuppressWarnings("finally")
	public int storeMA(Session session, String name, String vorname, String telnr, String adresse) {

		MitarbeiterEO test = new MitarbeiterEO();
		test.setM_name(name);
		test.setM_vorname(vorname);
		test.setM_telnr(telnr);
		test.setM_adresse(adresse);

		Transaction tx;
		tx = session.beginTransaction();
		try {
			session.save(test);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			return test.getM_id();
		}
	}
}
