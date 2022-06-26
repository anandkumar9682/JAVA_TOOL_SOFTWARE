import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Constructor;

import javax.swing.JFileChooser;
import java.io.File;
import java.io.FileWriter;

class AnandBind extends JFrame implements ActionListener,ItemListener {

JPanel mainPanel;
JMenuItem save,closeI;
JTextField getClassNameField;
JButton getInfoButton;

JRadioButton checkClassInterfaceRadio,getClassRadio ,getInterfaceRadios, allInfoClassRadio,getAllDataTypesRadio,getInterfaceRadio,getSuperClassRadio,getMethodRadio,getConstructorRadio,getFieldRadio,getModifierRadio,getPackageRadio,allInfoInterfaceRadio;

static JTextArea textArea;

JRadioButton selectItemButton;

static Class classT;

public static void main(String... a){
new AnandBind();
}


public AnandBind(){

Font font=new Font("Arial",Font.BOLD,15);

JMenuBar menuBar=new JMenuBar();
this.setJMenuBar(menuBar);
		
JMenu file=new JMenu("File");
menuBar.add(file);
 
save=new JMenuItem("Save");
save.addActionListener(this);
file.add(save);

closeI=new JMenuItem("Close");
closeI.addActionListener(this);
file.add(closeI);

mainPanel=new JPanel();
mainPanel.setLayout(null);
mainPanel.setBackground(Color.yellow);
this.add(mainPanel);

JPanel infoPanel=new JPanel();
infoPanel.setBackground(Color.red);
infoPanel.setLayout(null);
infoPanel.setBounds(30,15,1210,35);
mainPanel.add(infoPanel);

JLabel classNameInfo=new JLabel("Enter PackageWithClass: Ex-java.lang.String");
classNameInfo.setForeground(Color.white);
classNameInfo.setFont(font);
classNameInfo.setBounds(10,10,330,20);
infoPanel.add(classNameInfo);


getClassNameField=new JTextField();
getClassNameField.setBounds(345,8,400,20);
getClassNameField.setForeground(Color.red);
getClassNameField.setFont(font);
infoPanel.add(getClassNameField);

getInfoButton=new JButton("Get");
getInfoButton.setBounds(750,8,60,20);
getInfoButton.setForeground(Color.red);
getInfoButton.addActionListener(this);
infoPanel.add(getInfoButton);

ButtonGroup buttonGroup1=new ButtonGroup();

checkClassInterfaceRadio=new JRadioButton("check class or interface");
checkClassInterfaceRadio.addItemListener(this);
checkClassInterfaceRadio.setForeground(Color.white);
checkClassInterfaceRadio.setBackground(Color.red);
checkClassInterfaceRadio.setBounds(815,3,210,30);
buttonGroup1.add(checkClassInterfaceRadio);
infoPanel.add(checkClassInterfaceRadio);

getClassRadio=new JRadioButton("class");
getClassRadio.setEnabled(false);
getClassRadio.addItemListener(this);
getClassRadio.setForeground(Color.white);
getClassRadio.setBackground(Color.red);
getClassRadio.setBounds(1030,3,70,30);
buttonGroup1.add(getClassRadio);
infoPanel.add(getClassRadio);

getInterfaceRadios=new JRadioButton("interface");
getInterfaceRadios.setEnabled(false);
getInterfaceRadios.addItemListener(this);
getInterfaceRadios.setForeground(Color.white);
getInterfaceRadios.setBackground(Color.red);
getInterfaceRadios.setBounds(1105,3,210,30);
buttonGroup1.add(getInterfaceRadios);
infoPanel.add(getInterfaceRadios);

JPanel radioButtonPanel=new JPanel();
radioButtonPanel.setBounds(30,50,1210,35);
radioButtonPanel.setBackground(Color.green);
mainPanel.add(radioButtonPanel);

ButtonGroup buttonGroup2=new ButtonGroup();

allInfoClassRadio=new JRadioButton("Get All Information of the class");
allInfoClassRadio.addItemListener(this);
allInfoClassRadio.setEnabled(false);
allInfoClassRadio.setForeground(Color.blue);
allInfoClassRadio.setBackground(Color.green);
buttonGroup2.add(allInfoClassRadio);
radioButtonPanel.add(allInfoClassRadio);

getAllDataTypesRadio=new JRadioButton("Get All DataTypes");
getAllDataTypesRadio.setEnabled(false);
getAllDataTypesRadio.addItemListener(this);
getAllDataTypesRadio.setForeground(Color.blue);
getAllDataTypesRadio.setBackground(Color.green);
buttonGroup2.add(getAllDataTypesRadio);
radioButtonPanel.add(getAllDataTypesRadio);

getConstructorRadio=new JRadioButton("Get Constructor");
getConstructorRadio.setEnabled(false);
getConstructorRadio.addItemListener(this);
getConstructorRadio.setForeground(Color.blue);
getConstructorRadio.setBackground(Color.green);
buttonGroup2.add(getConstructorRadio);
radioButtonPanel.add(getConstructorRadio);

getInterfaceRadio=new JRadioButton("Get Interface");
getInterfaceRadio.setEnabled(false);
getInterfaceRadio.addItemListener(this);
getInterfaceRadio.setForeground(Color.blue);
getInterfaceRadio.setBackground(Color.green);
buttonGroup2.add(getInterfaceRadio);
radioButtonPanel.add(getInterfaceRadio);

getSuperClassRadio=new JRadioButton("Get Super Class");
getSuperClassRadio.setEnabled(false);
getSuperClassRadio.addItemListener(this);
getSuperClassRadio.setForeground(Color.blue);
getSuperClassRadio.setBackground(Color.green);
buttonGroup2.add(getSuperClassRadio);
radioButtonPanel.add(getSuperClassRadio);

getPackageRadio=new JRadioButton("Get Package");
getPackageRadio.setEnabled(false);
getPackageRadio.addItemListener(this);
getPackageRadio.setForeground(Color.blue);
getPackageRadio.setBackground(Color.green);
buttonGroup2.add(getPackageRadio);
radioButtonPanel.add(getPackageRadio);

JPanel radioButtonPanel1=new JPanel();
radioButtonPanel1.setBounds(30,85,1210,35);
radioButtonPanel1.setBackground(Color.pink);
mainPanel.add(radioButtonPanel1);

allInfoInterfaceRadio=new JRadioButton("Get All Information of the interface");
allInfoInterfaceRadio.addItemListener(this);
allInfoInterfaceRadio.setEnabled(false);
allInfoInterfaceRadio.setForeground(Color.blue);
allInfoInterfaceRadio.setBackground(Color.green);
buttonGroup2.add(allInfoInterfaceRadio);
radioButtonPanel1.add(allInfoInterfaceRadio);

getModifierRadio=new JRadioButton("Get Modifier");
getModifierRadio.setEnabled(false);
getModifierRadio.addItemListener(this);
getModifierRadio.setForeground(Color.blue);
getModifierRadio.setBackground(Color.green);
buttonGroup2.add(getModifierRadio);
radioButtonPanel1.add(getModifierRadio);

getFieldRadio=new JRadioButton("Get Field");
getFieldRadio.setEnabled(false);
getFieldRadio.addItemListener(this);
getFieldRadio.setForeground(Color.blue);
getFieldRadio.setBackground(Color.green);
buttonGroup2.add(getFieldRadio);
radioButtonPanel1.add(getFieldRadio);

getMethodRadio=new JRadioButton("Get Method");
getMethodRadio.setEnabled(false);
getMethodRadio.addItemListener(this);
getMethodRadio.setForeground(Color.blue);
getMethodRadio.setBackground(Color.green);
buttonGroup2.add(getMethodRadio);
radioButtonPanel1.add(getMethodRadio);


textArea=new JTextArea();
textArea.setForeground(Color.red);
textArea.setEditable(false);
textArea.setFont(font);
JScrollPane  scrollpane=new JScrollPane(textArea);
scrollpane.setBounds(30,130,1210,610);
mainPanel.add(scrollpane);

JLabel myInfo=new JLabel("Created By- Anand Bind");
myInfo.setFont(font);
myInfo.setForeground(Color.red);
myInfo.setBounds(550,740,240,20);
mainPanel.add(myInfo);

Dimension dimension=Toolkit.getDefaultToolkit().getScreenSize();

this.setSize(dimension.width-250, dimension.height-40);
this.setTitle("GUI POINT - Java Tool");
this.setVisible(true);
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
this.setResizable(false);


}

public void actionPerformed(ActionEvent aevt){

if(aevt.getSource()==getInfoButton){ 
textArea.setText(null);
if(getClassNameField.getText().trim().length()==0 ){
 JOptionPane.showMessageDialog(mainPanel,"Please Enter Package with class Name");} 
else{
String	userClassName=getClassNameField.getText().trim(); 
//getClassNameField.setText(null);
try{ 
 classT=Class.forName(userClassName); 

 resultSelected();
}
catch(ClassNotFoundException ex){  textArea.setText(ex+"\n"+"!!Not a class or interface!!");  }

}}
else if(aevt.getSource()==save){ saveFile(); }
else if(aevt.getSource()==closeI){ System.exit(0); }
}

public void itemStateChanged(ItemEvent ievt){
int selectedItem=ievt.getStateChange();
if(selectedItem==ItemEvent.SELECTED)
selectItemButton=(JRadioButton) ievt.getSource();
else if(selectItemButton==getAllDataTypesRadio){ allDataType(); }
 else{}
 }	


public void resultSelected(){
if(selectItemButton==checkClassInterfaceRadio){  checkInterfaceClassFunc();    }
else if(selectItemButton==allInfoClassRadio){ allInfoClassRadioMethod(); }
else if(selectItemButton==getInterfaceRadio){ interfacesC();  }
else if( selectItemButton==getSuperClassRadio){ superClass(); }
else if(selectItemButton==getConstructorRadio){ constructorsC();  }
else if(selectItemButton==getPackageRadio){ packageC(); }
else if(selectItemButton==getAllDataTypesRadio){allDataType();}


else if(selectItemButton==allInfoInterfaceRadio){  allInfoInterfaceRadioMethod();  }
else if(selectItemButton==getModifierRadio){  modifierC(); }	
else if(selectItemButton==getFieldRadio){ declaredFields(); }
else if(selectItemButton==getMethodRadio){ declaredMethods(); }
else{}
}


public void allInfoClassRadioMethod(){ 
textArea.append("declared Constructors :----------------------"+"\n");
textArea.append("\n");
constructorsC();
textArea.append("\n");textArea.append("\n");
textArea.append("Interfeces :------------------------------"+"\n");
textArea.append("\n");
interfacesC();
textArea.append("\n");textArea.append("\n");
textArea.append("Super Classes  :-------------------------"+"\n");
textArea.append("\n");
superClass();
textArea.append("\n");textArea.append("\n");
textArea.append("Package :-------------------------"+"\n");
textArea.append("\n");
packageC();
textArea.append("\n");textArea.append("\n");
textArea.append("declared Modifiers :--------------------"+"\n");
textArea.append("\n");
modifierC();
textArea.append("\n");textArea.append("\n");
textArea.append("declared Fields :-------------------"+"\n");
textArea.append("\n");
declaredFields();
textArea.append("\n");textArea.append("\n");
textArea.append("declared Methods :--------------------"+"\n");
textArea.append("\n");
declaredMethods();
textArea.append("\n");textArea.append("\n");
textArea.append("All Data Types :-----------------------"+"\n");
textArea.append("\n");
allDataType();

}

public void allInfoInterfaceRadioMethod(){ 
textArea.append("Package :--------------------------"+"\n");
textArea.append("\n");
packageC();
textArea.append("\n");textArea.append("\n");
textArea.append("declared Modifiers :-------------------"+"\n");
textArea.append("\n");
modifierC();
textArea.append("\n");textArea.append("\n");
textArea.append("declared Fields :---------------------"+"\n");
textArea.append("\n");
declaredFields();
textArea.append("\n");textArea.append("\n");
textArea.append("declared Methods :------------------"+"\n");
textArea.append("\n");
declaredMethods();
textArea.append("\n");textArea.append("\n");
textArea.append("All Data Types :----------------------"+"\n");
textArea.append("\n");
allDataType();
textArea.append("\n");textArea.append("\n");
}

public void checkInterfaceClassFunc(){

if(classT.isInterface()){
interfaceMethodBE();
 textArea.append("This is interface : "+classT.getName()+"\n");
 }
else{ 
classMethodBE();
 textArea.append("This is class : "+classT.getName()+"\n"); }
}

public void classMethodBE(){
 getClassRadio.setEnabled(true);
getClassRadio.setSelected(true);

allInfoClassRadio.setEnabled(true);
allInfoClassRadio.setSelected(true);
getConstructorRadio.setEnabled(true);
getInterfaceRadio.setEnabled(true);
getSuperClassRadio.setEnabled(true);
getPackageRadio.setEnabled(true);
getFieldRadio.setEnabled(true);
getModifierRadio.setEnabled(true);
getMethodRadio.setEnabled(true);
getAllDataTypesRadio.setEnabled(true);

}
public void interfaceMethodBE(){

getInterfaceRadios.setSelected(true); 
getInterfaceRadios.setEnabled(true);

allInfoInterfaceRadio.setEnabled(true);
allInfoInterfaceRadio.setSelected(true);
getFieldRadio.setEnabled(true);
getModifierRadio.setEnabled(true);
getMethodRadio.setEnabled(true);
getPackageRadio.setEnabled(true);
getAllDataTypesRadio.setEnabled(true);
getInterfaceRadio.setEnabled(true);

classMethodBD();

}

public void classMethodBD(){
 getClassRadio.setEnabled(false);
allInfoClassRadio.setEnabled(false);
getSuperClassRadio.setEnabled(false);
getConstructorRadio.setEnabled(false);
}


public void packageC(){
Package pk=classT.getPackage();
textArea.append(pk.getName()+"\n");

}


public void allDataType(){
textArea=textArea;

classT=int.class;
textArea.append("  "+classT.getName()+"\n");
classT=char.class;
textArea.append("  "+classT.getName()+"\n");
classT=float.class;
textArea.append("  "+classT.getName()+"\n");
classT=double.class;
textArea.append("  "+classT.getName()+"\n");
classT=long.class;
textArea.append("  "+classT.getName()+"\n");
classT=boolean.class;
textArea.append("  "+classT.getName()+"\n");
classT=byte.class;
textArea.append("  "+classT.getName()+"\n");
classT=short.class;
textArea.append("  "+classT.getName()+"\n");
classT=void.class;
textArea.append("  "+classT.getName()+"\n");
}

public void superClass(){
Class subClass=classT;
textArea.append(subClass.getName()+"\n");
Class superClass=subClass.getSuperclass();
while(superClass!=null){
textArea.append(superClass.getName()+"\n");
subClass=superClass;
superClass=subClass.getSuperclass();
}}


static void interfacesC(){
Class interfaces[]=classT.getInterfaces();
if(interfaces.length>0){
for(int i=0;i<interfaces.length;++i)
textArea.append(interfaces[i].getName()+"\n");
}}


static void constructorsC(){

Constructor[]constructors=classT.getDeclaredConstructors();
if(constructors.length>0){
for(int i=0;i<constructors.length;++i)
textArea.append(constructors[i].toString()+"\n");}

textArea.append("\n");textArea.append("\n");

Constructor cs[]=classT.getConstructors();
for(int i=0;i<cs.length;i++){
textArea.append(classT.getName()+"  ( ");
Class type[]=cs[i].getParameterTypes();
for(int k=0;k<type.length;k++){
textArea.append(type[k].getName()+",");}
textArea.append(" ) ");
textArea.append("  ");
textArea.append("\n");

}
}

public void declaredMethods(){

Method[] methods=classT.getDeclaredMethods();
if(methods.length>0){
for(int i=0;i<methods.length;++i){
textArea.append(methods[i].toString()+"\n");}
}

textArea.append("\n");
textArea.append("\n");

Method m[]=classT.getMethods();
for(int i=0;i<m.length;i++){
textArea.append(m[i].getReturnType().getName());
textArea.append("  "+m[i].getName());
textArea.append(" (");
Class type[]=m[i].getParameterTypes();
for(int k=0;k<type.length;k++){
textArea.append(type[k].getName()+",");}
textArea.append(" )");
textArea.append(" ");  
textArea.append("\n");
  }


}

public void declaredFields(){

Field fields[]=classT.getDeclaredFields();
if(fields.length>0){
for(int i=0;i<fields.length;++i)
textArea.append(fields[i].toString()+"\n");
}}


public void modifierC(){

int modifierVal=classT.getModifiers();
if(Modifier.isPublic(modifierVal))
textArea.append("public"+"\n");
if(Modifier.isFinal(modifierVal))
textArea.append("final"+"\n");
if(Modifier.isAbstract(modifierVal))
textArea.append("abstract");
}


void saveFile(){
JFileChooser j = new JFileChooser("Save File");  
int r = j.showSaveDialog(null); 
try{ 
if (r == JFileChooser.APPROVE_OPTION) { 
String f=j.getSelectedFile().getAbsolutePath();
 
FileWriter fw=new FileWriter(f);
String  s=textArea.getText();
fw.write(s);
fw.close();

File ff=j.getSelectedFile();
String name=ff.getName();
		   
} 

}catch(Exception e){}           }



}