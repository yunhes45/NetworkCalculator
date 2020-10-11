package com.example.ipcalculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.bar, menu) ;
        return true ;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.morebtn :
                View dialogView;
                dialogView = (View) View.inflate(MainActivity.this, R.layout.more, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setView(dialogView);
                dlg.show();

                return true ;
            default :
                return super.onOptionsItemSelected(item) ;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Network calculator");

        final EditText input1 = (EditText) findViewById(R.id.input1);
        final EditText input2 = (EditText) findViewById(R.id.input2);
        final EditText input3 = (EditText) findViewById(R.id.input3);
        final EditText input4 = (EditText) findViewById(R.id.input4);
        final EditText input5 = (EditText) findViewById(R.id.input5);

        final TextView subnettext = (TextView) findViewById(R.id.subnettext);

        final TextView setNetwork = (TextView) findViewById(R.id.setNetwork);
        final TextView setBroadcast = (TextView) findViewById(R.id.setBroadcast);
        final TextView setFirstAddress = (TextView) findViewById(R.id.setFirstAddress);
        final TextView setLastAddress = (TextView) findViewById(R.id.setLastAddress);

        final TextView binarysetNetwork = (TextView) findViewById(R.id.binarysetNetwork);
        final TextView binarysetBroadcast = (TextView) findViewById(R.id.binarysetBroadcast);
        final TextView binarysetFirstAddress = (TextView) findViewById(R.id.binarysetFirstAddress);
        final TextView binarysetLastAddress = (TextView) findViewById(R.id.binarysetLastAddress);

        final TextView setOctalNetwork = (TextView) findViewById(R.id.setOctalNetwork);
        final TextView setOctalBroadcast = (TextView) findViewById(R.id.setOctalBroadcast);
        final TextView setOctalFirstAddress = (TextView) findViewById(R.id.setOctalFirstAddress);
        final TextView setOctalLastAddress = (TextView) findViewById(R.id.setOctalLastAddress);

        final TextView setHexNetwork = (TextView) findViewById(R.id.setHexaNetwork);
        final TextView setHexBroadcast = (TextView) findViewById(R.id.setHexaBroadcast);
        final TextView setHexFirstAddress = (TextView) findViewById(R.id.setHexaFirstAddress);
        final TextView setHexLastAddress = (TextView) findViewById(R.id.setHexaLastAddress);

        //      Button subnetbtn = (Button) findViewById(R.id.subnetbtn);
        Button result = (Button) findViewById(R.id.result);
        Button clear = (Button) findViewById(R.id.clear);
        Button subnetbtn = (Button) findViewById(R.id.subnetbtn);

        final TextView setclass = (TextView) findViewById(R.id.setclass);



        subnetbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                PopupMenu popup = new PopupMenu(getApplicationContext(), view);
                popup.getMenuInflater().inflate(R.menu.subnetmask, popup.getMenu());

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()){
                          /*

                            case R.id.zero:  input5.setText("0"); subnettext.setText("0 . 0 . 0 . 0"); break;
                            case R.id.one:  input5.setText("1"); subnettext.setText("128 . 0 . 0 . 0"); break;
                            case R.id.two:  input5.setText("2"); subnettext.setText("192 . 0 . 0 . 0"); break;
                            case R.id.three:  input5.setText("3"); subnettext.setText("224 . 0 . 0 . 0"); break;
                            case R.id.four:  input5.setText("4"); subnettext.setText("240 . 0 . 0 . 0"); break;
                            case R.id.five:  input5.setText("5"); subnettext.setText("248 . 0 . 0 . 0"); break;
                            case R.id.six:  input5.setText("6"); subnettext.setText("252 . 0 . 0 . 0"); break;
                            case R.id.seven:  input5.setText("7"); subnettext.setText("254 . 0 . 0 . 0"); break;

                          */
                            case R.id.eight:  input5.setText("8"); subnettext.setText("255 . 0 . 0 . 0"); break;
                            case R.id.nine: input5.setText("9"); subnettext.setText("255 . 128 . 0 . 0"); break;
                            case R.id.ten: input5.setText("10"); subnettext.setText("255 . 192 . 0 . 0");  break;
                            case R.id.eleven: input5.setText("11"); subnettext.setText("255 . 224 . 0 . 0");  break;
                            case R.id.twelve: input5.setText("12"); subnettext.setText("255 . 240 . 0 . 0");  break;
                            case R.id.thirteen: input5.setText("13"); subnettext.setText("255 . 248 . 0 . 0");  break;
                            case R.id.fourteen: input5.setText("14"); subnettext.setText("255 . 252 . 0 . 0");  break;
                            case R.id.fifteen: input5.setText("15"); subnettext.setText("255 . 254 . 0 . 0");  break;
                            case R.id.sixteen: input5.setText("16"); subnettext.setText("255 . 255 . 0 . 0");  break;
                            case R.id.seventeen: input5.setText("17"); subnettext.setText("255 . 255 . 128 . 0");  break;
                            case R.id.eighteen: input5.setText("18"); subnettext.setText("255 . 255 . 192 . 0");  break;
                            case R.id.nineteen: input5.setText("19"); subnettext.setText("255 . 255 . 224 . 0");  break;
                            case R.id.twenty: input5.setText("20"); subnettext.setText("255 . 255 . 240 . 0");  break;
                            case R.id.twentyone: input5.setText("21"); subnettext.setText("255 . 255 . 248 . 0");  break;
                            case R.id.twentytwo: input5.setText("22"); subnettext.setText("255 . 255 . 252 . 0");  break;
                            case R.id.twentythree: input5.setText("23"); subnettext.setText("255 . 255 . 254 . 0");  break;
                            case R.id.twentyfour: input5.setText("24"); subnettext.setText("255 . 255 . 255 . 0");  break;
                            case R.id.twentyfive: input5.setText("25"); subnettext.setText("255 . 255 . 255 . 128");  break;
                            case R.id.twentysix: input5.setText("26"); subnettext.setText("255 . 255 . 255 . 192");  break;
                            case R.id.twentyseven: input5.setText("27"); subnettext.setText("255 . 255 . 255 . 224");  break;
                            case R.id.twentyeight: input5.setText("28"); subnettext.setText("255 . 255 . 255 . 240");  break;
                            case R.id.twentynine: input5.setText("29"); subnettext.setText("255 . 255 . 255 . 248");  break;
                            case R.id.thirty: input5.setText("30"); subnettext.setText("255 . 255 . 255 . 252");  break;
                            case R.id.thirtyone: input5.setText("31"); subnettext.setText("255 . 255 . 255 . 254");  break;
                            case R.id.thirtytwo: input5.setText("32"); subnettext.setText("255 . 255 . 255 . 255");  break;

                        }
                        return false;

                    }
                });
                popup.show();
            }
        });

        clear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast input1Msg = Toast.makeText(MainActivity.this, " CLEAR", Toast.LENGTH_LONG);
                input1Msg.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.CENTER_VERTICAL, 0, 0);
                input1Msg.show();
                input1.setText("");
                input2.setText("");
                input3.setText("");
                input4.setText("");
                input5.setText("");
                subnettext.setText("");

                setclass.setText("");

                setNetwork.setText("");
                setBroadcast.setText("");
                setFirstAddress.setText("");
                setLastAddress.setText("");

                setOctalNetwork.setText("");
                setOctalBroadcast.setText("");
                setOctalFirstAddress.setText("");
                setOctalLastAddress.setText("");

                binarysetNetwork.setText("");
                binarysetBroadcast.setText("");
                binarysetFirstAddress.setText("");
                binarysetLastAddress.setText("");

                setHexNetwork.setText("");
                setHexBroadcast.setText("");
                setHexFirstAddress.setText("");
                setHexLastAddress.setText("");

            }
        });

        result.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //Null값 처리
                String s;
                String getEditinput1 = input1.getText().toString();
                String getEditinput2 = input2.getText().toString();
                String getEditinput3 = input3.getText().toString();
                String getEditinput4 = input4.getText().toString();
                String getEditinput5 = input5.getText().toString();

                getEditinput1 = getEditinput1.trim();
                getEditinput2 = getEditinput2.trim();
                getEditinput3 = getEditinput3.trim();
                getEditinput4 = getEditinput4.trim();
                getEditinput5 = getEditinput5.trim();


                if(getEditinput1.getBytes().length <= 0){
                    s = "192" + getEditinput1;
                    input1.setText(s);
                    Toast input1Msg = Toast.makeText(MainActivity.this, " 값을 입력해주세요", Toast.LENGTH_LONG);
                    input1Msg.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.CENTER_VERTICAL, 0, 0);
                    input1Msg.show();
                }
                if(getEditinput2.getBytes().length <= 0){
                    s = "168" + getEditinput2;
                    input2.setText(s);
                    Toast input1Msg = Toast.makeText(MainActivity.this, " 값을 입력해주세요", Toast.LENGTH_LONG);
                    input1Msg.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.CENTER_VERTICAL, 0, 0);
                    input1Msg.show();
                }
                if(getEditinput3.getBytes().length <= 0){
                    s = "0" + getEditinput3;
                    input3.setText(s);
                    Toast input1Msg = Toast.makeText(MainActivity.this, " 값을 입력해주세요", Toast.LENGTH_LONG);
                    input1Msg.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.CENTER_VERTICAL, 0, 0);
                    input1Msg.show();
                }
                if(getEditinput4.getBytes().length <= 0){
                    s = "1" + getEditinput4;
                    input4.setText(s);
                    Toast input1Msg = Toast.makeText(MainActivity.this, " 값을 입력해주세요", Toast.LENGTH_LONG);
                    input1Msg.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.CENTER_VERTICAL, 0, 0);
                    input1Msg.show();
                }
                if(getEditinput5.getBytes().length <= 0){
                    s = "24" + getEditinput5;
                    input5.setText(s);
                    Toast input1Msg = Toast.makeText(MainActivity.this, " 값을 입력해주세요", Toast.LENGTH_LONG);
                    input1Msg.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.CENTER_VERTICAL, 0, 0);
                    input1Msg.show();
                }
                //Null값 처리

                int s1 = Integer.parseInt(input1.getText().toString());
                int s2 = Integer.parseInt(input2.getText().toString());
                int s3 = Integer.parseInt(input3.getText().toString());
                int s4 = Integer.parseInt(input4.getText().toString());
                int cidr = Integer.parseInt(input5.getText().toString());

                // 네트워크어드레스 계산
                int input4x = 32-cidr;
                int input3x = 24-cidr;
                int input2x = 16-cidr;
                int input1x = 8-cidr;

                int input4y = (int)Math.pow(2, input4x);
                int input3y = (int)Math.pow(2, input3x);
                int input2y = (int)Math.pow(2, input2x);
                int input1y = (int)Math.pow(2, input1x);

                int input4z = 256 - input4y;
                int input3z = 256 - input3y;
                int input2z = 256 - input2y;
                int input1z = 256 - input1y;
                // 네트워크어드레스 계산

                //브로드캐스트 계산
                int broadsolid = 255;
                //브로드캐스트 계산


                //첫번째 자리 if문
                if(cidr <= 7){
                    setclass.setText("");
                }else if(s1 >=0 && s1 <=126){
                    setclass.setText("A Class (Public)");
                }else if(s1 >=128 && s1 <=191){
                    setclass.setText("B Class (Public)");
                }else if(s1 == 192){
                    setclass.setText("C Class (Private)");
                }else if(s1 >=193 && s1 <=223){
                    setclass.setText("C Class (Public)");
                }else if(s1 >=224 && s1 <=239){
                    setclass.setText("D Class (Multicast)");
                }else if(s1 >=240 && s1 <=255){
                    setclass.setText("E Class (Reserved)");
                }else if(s1 ==0 || s1 ==127){
                    setclass.setText("A Class (Loopback)");
                }else if(s1 >=256){
                    s = "192";
                    input1.setText(s);
                    Toast input1Msg = Toast.makeText(MainActivity.this, " 0 ~ 255까지의 값을 입력해주세요", Toast.LENGTH_LONG);
                    input1Msg.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.CENTER_VERTICAL, 0, 0);
                    input1Msg.show();
                }
                //첫번째 자리 if문

                //두번째 자리 if문
                if(s2 >= 256){
                    s = "168";
                    input2.setText(s);
                    Toast input1Msg = Toast.makeText(MainActivity.this, " 0 ~ 255까지의 값을 입력해주세요", Toast.LENGTH_LONG);
                    input1Msg.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.CENTER_VERTICAL, 0, 0);
                    input1Msg.show();
                }
                //두번째 자리 if문

                //세번째 자리 if문
                if(s3 >= 256){
                    s = "0";
                    input3.setText(s);
                    Toast input1Msg = Toast.makeText(MainActivity.this, " 0 ~ 255까지의 값을 입력해주세요", Toast.LENGTH_LONG);
                    input1Msg.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.CENTER_VERTICAL, 0, 0);
                    input1Msg.show();
                }
                //세번째 자리 if문

                //네번째 자리 if문
                if(s4 >= 256){
                    s = "1";
                    input4.setText(s);
                    Toast input1Msg = Toast.makeText(MainActivity.this, " 0 ~ 255까지의 값을 입력해주세요", Toast.LENGTH_LONG);
                    input1Msg.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.CENTER_VERTICAL, 0, 0);
                    input1Msg.show();
                }
                //네번째 자리 if문

                //다섯번째 자리 if문
                if(cidr >= 33 || cidr < 8){
                    s = "24";
                    input5.setText(s);
                    Toast input1Msg = Toast.makeText(MainActivity.this, " 8 ~ 32까지의 값을 입력해주세요", Toast.LENGTH_LONG);
                    input1Msg.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.CENTER_VERTICAL, 0, 0);
                    input1Msg.show();
                }
                //다섯번째 자리 if문

                //CIDR 출력, 계산
                if(cidr >=24 && cidr <=30){
                    int resultnet4 = s4 & input4z;
                    int resultbroad4 = resultnet4 + input4y -1;
                    int resultfirst4 = resultnet4 + 1;
                    int resultlast4 = resultbroad4 - 1;
                    subnettext.setText(broadsolid+" . "+broadsolid+" . "+broadsolid+" . "+ input4z);
                    setNetwork.setText(Integer.parseInt(input1.getText().toString())+" . "+Integer.parseInt(input2.getText().toString())+" . "+Integer.parseInt(input3.getText().toString())+" . "+resultnet4);
                    setBroadcast.setText(Integer.parseInt(input1.getText().toString())+" . "+Integer.parseInt(input2.getText().toString())+" . "+Integer.parseInt(input3.getText().toString())+" . "+ resultbroad4);
                    setFirstAddress.setText(Integer.parseInt(input1.getText().toString())+" . "+Integer.parseInt(input2.getText().toString())+" . "+Integer.parseInt(input3.getText().toString())+" . "+resultfirst4);
                    setLastAddress.setText(Integer.parseInt(input1.getText().toString())+" . "+Integer.parseInt(input2.getText().toString())+" . "+Integer.parseInt(input3.getText().toString())+" . "+ resultlast4);
                    //10진수

                    int binaryres1 = Integer.parseInt(input1.getText().toString());
                    int binaryres2 = Integer.parseInt(input2.getText().toString());
                    int binaryres3 = Integer.parseInt(input3.getText().toString());

                    int binaryresnet4 = resultnet4;
                    int binaryresbroad4 = resultbroad4;
                    int binaryresfirst4 = resultfirst4;
                    int binaryreslast4 = resultlast4;

                    String binaryresult1 = "00000000"+Integer.toBinaryString(binaryres1);
                    String binaryresult2 = "00000000"+Integer.toBinaryString(binaryres2);
                    String binaryresult3 = "00000000"+Integer.toBinaryString(binaryres3);

                    String binaryresultnet4 = "00000000"+Integer.toBinaryString(binaryresnet4);
                    String binaryresultbroad4 = "00000000"+Integer.toBinaryString(binaryresbroad4);
                    String binaryresultfirst4 = "00000000"+Integer.toBinaryString(binaryresfirst4);
                    String binaryresultlast4 = "00000000"+Integer.toBinaryString(binaryreslast4);

                    binarysetNetwork.setText(binaryresult1.substring(binaryresult1.length()-8, binaryresult1.length())
                            +" . "+binaryresult2.substring(binaryresult2.length()-8, binaryresult2.length())
                            +" . "+binaryresult3.substring(binaryresult3.length()-8, binaryresult3.length())
                            + " . "+binaryresultnet4.substring(binaryresultnet4.length()-8, binaryresultnet4.length()));
                    binarysetBroadcast.setText(binaryresult1.substring(binaryresult1.length()-8, binaryresult1.length())
                            +" . "+binaryresult2.substring(binaryresult2.length()-8, binaryresult2.length())
                            +" . "+binaryresult3.substring(binaryresult3.length()-8, binaryresult3.length())
                            +" . "+binaryresultbroad4.substring(binaryresultbroad4.length()-8, binaryresultbroad4.length()));
                    binarysetFirstAddress.setText(binaryresult1.substring(binaryresult1.length()-8, binaryresult1.length())
                            +" . "+binaryresult2.substring(binaryresult2.length()-8, binaryresult2.length())
                            +" . "+binaryresult3.substring(binaryresult3.length()-8, binaryresult3.length())
                            +" . "+binaryresultfirst4.substring(binaryresultfirst4.length()-8, binaryresultfirst4.length()));
                    binarysetLastAddress.setText(binaryresult1.substring(binaryresult1.length()-8, binaryresult1.length())
                            +" . "+binaryresult2.substring(binaryresult2.length()-8, binaryresult2.length())
                            +" . "+binaryresult3.substring(binaryresult3.length()-8, binaryresult3.length())
                            +" . "+binaryresultlast4.substring(binaryresultlast4.length()-8, binaryresultlast4.length()));
                    //2진수

                    int octalres1 = Integer.parseInt(input1.getText().toString());
                    int octalres2 = Integer.parseInt(input2.getText().toString());
                    int octalres3 = Integer.parseInt(input3.getText().toString());

                    setOctalNetwork.setText(Integer.toOctalString(octalres1)+" . "+Integer.toOctalString(octalres2)+" . "+Integer.toOctalString(octalres3)+" . "+Integer.toOctalString(resultnet4));
                    setOctalBroadcast.setText(Integer.toOctalString(octalres1)+" . "+Integer.toOctalString(octalres2)+" . "+Integer.toOctalString(octalres3)+" . "+Integer.toOctalString(resultbroad4));
                    setOctalFirstAddress.setText(Integer.toOctalString(octalres1)+" . "+Integer.toOctalString(octalres2)+" . "+Integer.toOctalString(octalres3)+" . "+Integer.toOctalString(resultfirst4));
                    setOctalLastAddress.setText(Integer.toOctalString(octalres1)+" . "+Integer.toOctalString(octalres2)+" . "+Integer.toOctalString(octalres3)+" . "+Integer.toOctalString(resultlast4));
                    //8진수

                    int Hexres1 = Integer.parseInt(input1.getText().toString());
                    int Hexres2 = Integer.parseInt(input2.getText().toString());
                    int Hexres3 = Integer.parseInt(input3.getText().toString());

                    int Hexresnet4 = resultnet4;
                    int Hexresbroad4 = resultbroad4;
                    int Hexresfirst4 = resultfirst4;
                    int Hexreslast4 = resultlast4;

                    String Hexresult1 = "00"+Integer.toHexString(Hexres1);
                    String Hexresult2 = "00"+Integer.toHexString(Hexres2);
                    String Hexresult3 = "00"+Integer.toHexString(Hexres3);

                    String Hexresultnet4 = "00"+Integer.toHexString(Hexresnet4);
                    String Hexresultbroad4 = "00"+Integer.toHexString(Hexresbroad4);
                    String Hexresultfirst4 = "00"+Integer.toHexString(Hexresfirst4);
                    String Hexresultlast4 = "00"+Integer.toHexString(Hexreslast4);

                    setHexNetwork.setText(Hexresult1.substring(Hexresult1.length()-2, Hexresult1.length())
                            +" . "+Hexresult2.substring(Hexresult2.length()-2, Hexresult2.length())
                            +" . "+Hexresult3.substring(Hexresult3.length()-2, Hexresult3.length())
                            +" . "+Hexresultnet4.substring(Hexresultnet4.length()-2, Hexresultnet4.length()));
                    setHexBroadcast.setText(Hexresult1.substring(Hexresult1.length()-2, Hexresult1.length())
                            +" . "+Hexresult2.substring(Hexresult2.length()-2, Hexresult2.length())
                            +" . "+Hexresult3.substring(Hexresult3.length()-2, Hexresult3.length())
                            +" . "+Hexresultbroad4.substring(Hexresultbroad4.length()-2, Hexresultbroad4.length()));
                    setHexFirstAddress.setText(Hexresult1.substring(Hexresult1.length()-2, Hexresult1.length())
                            +" . "+Hexresult2.substring(Hexresult2.length()-2, Hexresult2.length())
                            +" . "+Hexresult3.substring(Hexresult3.length()-2, Hexresult3.length())
                            +" . "+Hexresultfirst4.substring(Hexresultfirst4.length()-2, Hexresultfirst4.length()));
                    setHexLastAddress.setText(Hexresult1.substring(Hexresult1.length()-2, Hexresult1.length())
                            +" . "+Hexresult2.substring(Hexresult2.length()-2, Hexresult2.length())
                            +" . "+Hexresult3.substring(Hexresult3.length()-2, Hexresult3.length())
                            +" . "+Hexresultlast4.substring(Hexresultlast4.length()-2, Hexresultlast4.length()));
                    //16진수

                }
                if(cidr >=16 && cidr <=23){
                    int resultnet3 = s3 & input3z;
                    int resultnet4 = s4 & input4z;
                    int resultbroad3 = resultnet3 + input3y - 1;
                    int resultfirst4 = resultnet4 + 1;
                    int resultlast4 = broadsolid - 1;
                    subnettext.setText(broadsolid+" . "+broadsolid+" . "+input3z+" . "+ "0");
                    setNetwork.setText(Integer.parseInt(input1.getText().toString())+" . "+Integer.parseInt(input2.getText().toString())+" . "+resultnet3+" . "+resultnet4);
                    setBroadcast.setText(Integer.parseInt(input1.getText().toString())+" . "+Integer.parseInt(input2.getText().toString())+" . "+resultbroad3+" . "+ broadsolid);
                    setFirstAddress.setText(Integer.parseInt(input1.getText().toString())+" . "+Integer.parseInt(input2.getText().toString())+" . "+resultnet3+" . "+resultfirst4);
                    setLastAddress.setText(Integer.parseInt(input1.getText().toString())+" . "+Integer.parseInt(input2.getText().toString())+" . "+resultbroad3+" . "+ resultlast4);
                    //10진수

                    int binaryres1 = Integer.parseInt(input1.getText().toString());
                    int binaryres2 = Integer.parseInt(input2.getText().toString());

                    int binaryresnet3 = resultnet3;
                    int binaryresnet4 = resultnet4;
                    int binaryresbroadnet3 = resultbroad3;
                    int binaryresfirstnet4 = resultfirst4;
                    int binaryreslastnet4 = resultlast4;

                    String binaryresult1 = "00000000"+Integer.toBinaryString(binaryres1);
                    String binaryresult2 = "00000000"+Integer.toBinaryString(binaryres2);

                    String binaryresultnet3 = "00000000"+Integer.toBinaryString(binaryresnet3);
                    String binaryresultnet4 = "00000000"+Integer.toBinaryString(binaryresnet4);
                    String binaryresultbroadnet3 = "00000000"+Integer.toBinaryString(binaryresbroadnet3);
                    String binaryresultfirstnet4 = "00000000"+Integer.toBinaryString(binaryresfirstnet4);
                    String binaryresultlastnet4 = "00000000"+Integer.toBinaryString(binaryreslastnet4);

                    binarysetNetwork.setText(binaryresult1.substring(binaryresult1.length()-8, binaryresult1.length())
                            +" . "+binaryresult2.substring(binaryresult2.length()-8, binaryresult2.length())
                            +" . "+binaryresultnet3.substring(binaryresultnet3.length()-8, binaryresultnet3.length())
                            +" . "+binaryresultnet4.substring(binaryresultnet4.length()-8, binaryresultnet4.length()));
                    binarysetBroadcast.setText(binaryresult1.substring(binaryresult1.length()-8, binaryresult1.length())
                            +" . "+binaryresult2.substring(binaryresult2.length()-8, binaryresult2.length())
                            +" . "+binaryresultbroadnet3.substring(binaryresultbroadnet3.length()-8, binaryresultbroadnet3.length())
                            +" . "+ Integer.toBinaryString(broadsolid));
                    binarysetFirstAddress.setText(binaryresult1.substring(binaryresult1.length()-8, binaryresult1.length())
                            +" . "+binaryresult2.substring(binaryresult2.length()-8, binaryresult2.length())
                            +" . "+binaryresultnet3.substring(binaryresultnet3.length()-8, binaryresultnet3.length())
                            +" . "+binaryresultfirstnet4.substring(binaryresultfirstnet4.length()-8, binaryresultfirstnet4.length()));
                    binarysetLastAddress.setText(binaryresult1.substring(binaryresult1.length()-8, binaryresult1.length())
                            +" . "+binaryresult2.substring(binaryresult2.length()-8, binaryresult2.length())
                            +" . "+binaryresultbroadnet3.substring(binaryresultbroadnet3.length()-8, binaryresultbroadnet3.length())
                            +" . "+ binaryresultlastnet4.substring(binaryresultlastnet4.length()-8, binaryresultlastnet4.length()));
                    //2진수

                    int octalres1 = Integer.parseInt(input1.getText().toString());
                    int octalres2 = Integer.parseInt(input2.getText().toString());

                    setOctalNetwork.setText(Integer.toOctalString(octalres1)+" : "+Integer.toOctalString(octalres2)+" : "+Integer.toOctalString(resultnet3)+" : "+Integer.toOctalString(resultnet4));
                    setOctalBroadcast.setText(Integer.toOctalString(octalres1)+" : "+Integer.toOctalString(octalres2)+" : "+Integer.toOctalString(resultbroad3)+" : "+ Integer.toOctalString(broadsolid));
                    setOctalFirstAddress.setText(Integer.toOctalString(octalres1)+" : "+Integer.toOctalString(octalres2)+" : "+Integer.toOctalString(resultnet3)+" : "+Integer.toOctalString(resultfirst4));
                    setOctalLastAddress.setText(Integer.toOctalString(octalres1)+" : "+Integer.toOctalString(octalres2)+" : "+Integer.toOctalString(resultbroad3)+" : "+ Integer.toOctalString(resultlast4));
                    //8진수

                    int Hexres1 = Integer.parseInt(input1.getText().toString());
                    int Hexres2 = Integer.parseInt(input2.getText().toString());

                    int Hexresnet3 = resultnet3;
                    int Hexresnet4 = resultnet4;
                    int Hexresbroad3 = resultbroad3;
                    int Hexresfirst4 = resultfirst4;
                    int Hexreslast4 = resultlast4;

                    String Hexresult1 = "00"+Integer.toHexString(Hexres1);
                    String Hexresult2 = "00"+Integer.toHexString(Hexres2);

                    String Hexresultnet3 = "00"+Integer.toHexString(Hexresnet3);
                    String Hexresultnet4 = "00"+Integer.toHexString(Hexresnet4);
                    String Hexresultbroad3 = "00"+Integer.toHexString(Hexresbroad3);
                    String Hexresultfirst4 = "00"+Integer.toHexString(Hexresfirst4);
                    String Hexresultlast4 = "00"+Integer.toHexString(Hexreslast4);

                    setHexNetwork.setText(Hexresult1.substring(Hexresult1.length()-2, Hexresult1.length())
                            +" . "+Hexresult2.substring(Hexresult2.length()-2, Hexresult2.length())
                            +" . "+Hexresultnet3.substring(Hexresultnet3.length()-2, Hexresultnet3.length())
                            +" : "+Hexresultnet4.substring(Hexresultnet4.length()-2, Hexresultnet4.length()));
                    setHexBroadcast.setText(Hexresult1.substring(Hexresult1.length()-2, Hexresult1.length())
                            +" . "+Hexresult2.substring(Hexresult2.length()-2, Hexresult2.length())
                            +" . "+Hexresultbroad3.substring(Hexresultbroad3.length()-2, Hexresultbroad3.length())
                            +" : "+ Integer.toHexString(broadsolid));
                    setHexFirstAddress.setText(Hexresult1.substring(Hexresult1.length()-2, Hexresult1.length())
                            +" . "+Hexresult2.substring(Hexresult2.length()-2, Hexresult2.length())
                            +" . "+Hexresultnet3.substring(Hexresultnet3.length()-2, Hexresultnet3.length())
                            +" . "+Hexresultfirst4.substring(Hexresultfirst4.length()-2, Hexresultfirst4.length()));
                    setHexLastAddress.setText(Hexresult1.substring(Hexresult1.length()-2, Hexresult1.length())
                            +" . "+Hexresult2.substring(Hexresult2.length()-2, Hexresult2.length())
                            +" . "+Hexresultbroad3.substring(Hexresultbroad3.length()-2, Hexresultbroad3.length())
                            +" . "+Hexresultlast4.substring(Hexresultlast4.length()-2, Hexresultlast4.length()));
                    //16진수
                }
                if(cidr >=8 && cidr<=15){
                    int resultnet2 = s2 & input2z;
                    int resultnet3 = s3 & input3z;
                    int resultnet4 = s4 & input4z;
                    int resultbroad2 = resultnet2 + input2y - 1;
                    int resultfirst4 = resultnet4 + 1;
                    int resultlast4 = broadsolid - 1;
                    subnettext.setText(broadsolid+" . "+input2z+" . "+"0"+" . "+ "0");
                    setNetwork.setText(Integer.parseInt(input1.getText().toString())+" . "+resultnet2+" . "+resultnet3 +" . "+resultnet4);
                    setBroadcast.setText(Integer.parseInt(input1.getText().toString())+" . "+resultbroad2+" . "+broadsolid +" . "+ broadsolid);
                    setFirstAddress.setText(Integer.parseInt(input1.getText().toString())+" . "+resultnet2+" . "+resultnet3 +" . "+resultfirst4);
                    setLastAddress.setText(Integer.parseInt(input1.getText().toString())+" . "+resultbroad2+" . "+broadsolid +" . "+ resultlast4);
                    //10진수

                    int binaryres1 = Integer.parseInt(input1.getText().toString());

                    int binaryresnet2 = resultnet2;
                    int binaryresnet3 = resultnet3;
                    int binaryresnet4 = resultnet4;
                    int binaryresbroadnet2 = resultbroad2;
                    int binaryresfirstnet4 = resultfirst4;
                    int binaryreslastnet4 = resultlast4;

                    String binaryresult1 = "00000000"+Integer.toBinaryString(binaryres1);

                    String binaryresultnet2 = "00000000"+Integer.toBinaryString(binaryresnet2);
                    String binaryresultnet3 = "00000000"+Integer.toBinaryString(binaryresnet3);
                    String binaryresultnet4 = "00000000"+Integer.toBinaryString(binaryresnet4);
                    String binaryresultbroadnet2 = "00000000"+Integer.toBinaryString(binaryresbroadnet2);
                    String binaryresultfirstnet4 = "00000000"+Integer.toBinaryString(binaryresfirstnet4);
                    String binaryresultlastnet4 = "00000000"+Integer.toBinaryString(binaryreslastnet4);

                    binarysetNetwork.setText(binaryresult1.substring(binaryresult1.length()-8, binaryresult1.length())
                            +" . "+binaryresultnet2.substring(binaryresultnet2.length()-8, binaryresultnet2.length())
                            +" . "+binaryresultnet3.substring(binaryresultnet3.length()-8, binaryresultnet3.length())
                            +" . "+binaryresultnet4.substring(binaryresultnet4.length()-8, binaryresultnet4.length()));
                    binarysetBroadcast.setText(binaryresult1.substring(binaryresult1.length()-8, binaryresult1.length())
                            +" . "+binaryresultbroadnet2.substring(binaryresultbroadnet2.length()-8, binaryresultbroadnet2.length())
                            +" . "+Integer.toBinaryString(broadsolid)
                            +" . "+ Integer.toBinaryString(broadsolid));
                    binarysetFirstAddress.setText(binaryresult1.substring(binaryresult1.length()-8, binaryresult1.length())
                            +" . "+binaryresultnet2.substring(binaryresultnet2.length()-8, binaryresultnet2.length())
                            +" . "+binaryresultnet3.substring(binaryresultnet3.length()-8, binaryresultnet3.length())
                            +" . "+binaryresultfirstnet4.substring(binaryresultfirstnet4.length()-8, binaryresultfirstnet4.length()));
                    binarysetLastAddress.setText(binaryresult1.substring(binaryresult1.length()-8, binaryresult1.length())
                            +" . "+binaryresultbroadnet2.substring(binaryresultbroadnet2.length()-8, binaryresultbroadnet2.length())
                            +" . " +Integer.toBinaryString(broadsolid)
                            +" . " +binaryresultlastnet4.substring(binaryresultlastnet4.length()-8, binaryresultlastnet4.length()));
                    //2진수

                    int octalres1 = Integer.parseInt(input1.getText().toString());

                    setOctalNetwork.setText(Integer.toOctalString(octalres1)+" : "+Integer.toOctalString(resultnet2)+" : "+Integer.toOctalString(resultnet3) +" : "+Integer.toOctalString(resultnet4));
                    setOctalBroadcast.setText(Integer.toOctalString(octalres1)+" : "+Integer.toOctalString(resultbroad2)+" : "+Integer.toOctalString(broadsolid) +" : "+ Integer.toOctalString(broadsolid));
                    setOctalFirstAddress.setText(Integer.toOctalString(octalres1)+" : "+Integer.toOctalString(resultnet2)+" : "+Integer.toOctalString(resultnet3) +" : "+Integer.toOctalString(resultfirst4));
                    setOctalLastAddress.setText(Integer.toOctalString(octalres1)+" : "+Integer.toOctalString(resultbroad2)+" : "+Integer.toOctalString(broadsolid) +" : "+ Integer.toOctalString(resultlast4));
                    //8진수

                    int Hexres1 = Integer.parseInt(input1.getText().toString());

                    int Hexresnet2 = resultnet2;
                    int Hexresnet3 = resultnet3;
                    int Hexresnet4 = resultnet4;
                    int Hexresbroad2 = resultbroad2;
                    int Hexresfirst4 = resultfirst4;
                    int Hexreslast4 = resultlast4;

                    String Hexresult1 = "00"+Integer.toHexString(Hexres1);

                    String Hexresultnet2 = "00"+Integer.toHexString(Hexresnet2);
                    String Hexresultnet3 = "00"+Integer.toHexString(Hexresnet3);
                    String Hexresultnet4 = "00"+Integer.toHexString(Hexresnet4);
                    String Hexresultbroad2 = "00"+Integer.toHexString(Hexresbroad2);
                    String Hexresultfirst4 = "00"+Integer.toHexString(Hexresfirst4);
                    String Hexresultlast4 = "00"+Integer.toHexString(Hexreslast4);

                    setHexNetwork.setText(Hexresult1.substring(Hexresult1.length()-2, Hexresult1.length())
                            +" : "+Hexresultnet2.substring(Hexresultnet2.length()-2, Hexresultnet2.length())
                            +" : "+Hexresultnet3.substring(Hexresultnet3.length()-2, Hexresultnet3.length())
                            +" : "+Hexresultnet4.substring(Hexresultnet4.length()-2, Hexresultnet4.length()));
                    setHexBroadcast.setText(Hexresult1.substring(Hexresult1.length()-2, Hexresult1.length())
                            +" : "+Hexresultbroad2.substring(Hexresultbroad2.length()-2, Hexresultbroad2.length())
                            +" : "+Integer.toHexString(broadsolid)
                            +" : "+ Integer.toHexString(broadsolid));
                    setHexFirstAddress.setText(Hexresult1.substring(Hexresult1.length()-2, Hexresult1.length())
                            +" : "+Hexresultnet2.substring(Hexresultnet2.length()-2, Hexresultnet2.length())
                            +" : "+Hexresultnet3.substring(Hexresultnet3.length()-2, Hexresultnet3.length())
                            +" : "+Hexresultfirst4.substring(Hexresultfirst4.length()-2, Hexresultfirst4.length()));
                    setHexLastAddress.setText(Hexresult1.substring(Hexresult1.length()-2, Hexresult1.length())
                            +" : "+Hexresultbroad2.substring(Hexresultbroad2.length()-2, Hexresultbroad2.length())
                            +" : "+Integer.toHexString(broadsolid)
                            +" : "+Hexresultlast4 .substring(Hexresultlast4 .length()-2, Hexresultlast4 .length()));
                    //16진수

                }
                /*
                if(cidr>=0 && cidr<=7) {
                    int resultnet1 = s1 & input1z;
                    int resultnet2 = s2 & input2z;
                    int resultnet3 = s3 & input3z;
                    int resultnet4 = s4 & input4z;
                    int resultbroad1 = resultnet1 + input1y - 1;
                    int resultfirst4 = resultnet4 + 1;
                    int resultlast4 = broadsolid - 1;
                    subnettext.setText(input1z+" . "+"0"+" . "+"0"+" . "+ "0");
                    setNetwork.setText(resultnet1 + " . " + resultnet2 + " . " + resultnet3 + " . " + resultnet4);
                    setBroadcast.setText(resultbroad1 + " . " + broadsolid + " . " + broadsolid + " . " + broadsolid);
                    setFirstAddress.setText(resultnet1 + " . " + resultnet2 + " . " + resultnet3 + " . " + resultfirst4);
                    setLastAddress.setText(resultbroad1 + " . " + broadsolid + " . " + broadsolid + " . " + resultlast4);
                    //10진수

                    int binaryresnet1 = resultnet1;
                    int binaryresnet2 = resultnet2;
                    int binaryresnet3 = resultnet3;
                    int binaryresnet4 = resultnet4;
                    int binaryresbroadnet1 = resultbroad1;
                    int binaryresfirstnet4 = resultfirst4;
                    int binaryreslastnet4 = resultlast4;

                    String binaryresultnet1 = "00000000"+Integer.toBinaryString(binaryresnet1);
                    String binaryresultnet2 = "00000000"+Integer.toBinaryString(binaryresnet2);
                    String binaryresultnet3 = "00000000"+Integer.toBinaryString(binaryresnet3);
                    String binaryresultnet4 = "00000000"+Integer.toBinaryString(binaryresnet4);
                    String binaryresultbroadnet1 = "00000000"+Integer.toBinaryString(binaryresbroadnet1);
                    String binaryresultfirstnet4 = "00000000"+Integer.toBinaryString(binaryresfirstnet4);
                    String binaryresultlastnet4 = "00000000"+Integer.toBinaryString(binaryreslastnet4);

                    binarysetNetwork.setText(binaryresultnet1.substring(binaryresultnet1.length()-8, binaryresultnet1.length())
                            + " . " + binaryresultnet2.substring(binaryresultnet2.length()-8, binaryresultnet2.length())
                            + " . " + binaryresultnet3.substring(binaryresultnet3.length()-8, binaryresultnet3.length())
                            + " . " + binaryresultnet4.substring(binaryresultnet4.length()-8, binaryresultnet4.length()));
                    binarysetBroadcast.setText(binaryresultbroadnet1.substring(binaryresultbroadnet1.length()-8, binaryresultbroadnet1.length())
                            + " . " + Integer.toBinaryString(broadsolid)
                            + " . " + Integer.toBinaryString(broadsolid)
                            + " . " + Integer.toBinaryString(broadsolid));
                    binarysetFirstAddress.setText(binaryresultnet1.substring(binaryresultnet1.length()-8, binaryresultnet1.length())
                            + " . " + binaryresultnet2.substring(binaryresultnet2.length()-8, binaryresultnet2.length())
                            + " . " + binaryresultnet3.substring(binaryresultnet3.length()-8, binaryresultnet3.length())
                            + " . " + binaryresultfirstnet4.substring(binaryresultfirstnet4.length()-8, binaryresultfirstnet4.length()));
                    binarysetLastAddress.setText(binaryresultbroadnet1.substring(binaryresultbroadnet1.length()-8, binaryresultbroadnet1.length())
                            + " . " + Integer.toBinaryString(broadsolid)
                            + " . " + Integer.toBinaryString(broadsolid)
                            + " . " + binaryresultlastnet4.substring(binaryresultlastnet4.length()-8, binaryresultlastnet4.length()));
                    //2진수

                    setOctalNetwork.setText(Integer.toOctalString(resultnet1) + " : " + Integer.toOctalString(resultnet2) + " : " + Integer.toOctalString(resultnet3) + " : " + Integer.toOctalString(resultnet4));
                    setOctalBroadcast.setText(Integer.toOctalString(resultbroad1) + " : " + Integer.toOctalString(broadsolid) + " : " + Integer.toOctalString(broadsolid) + " : " + Integer.toOctalString(broadsolid));
                    setOctalFirstAddress.setText(Integer.toOctalString(resultnet1) + " : " + Integer.toOctalString(resultnet2) + " : " + Integer.toOctalString(resultnet3) + " : " + Integer.toOctalString(resultfirst4));
                    setOctalLastAddress.setText(Integer.toOctalString(resultbroad1) + " : " + Integer.toOctalString(broadsolid) + " : " + Integer.toOctalString(broadsolid) + " : " + Integer.toOctalString(resultlast4));
                    //8진수

                    int Hexresnet1 = resultnet1;
                    int Hexresnet2 = resultnet2;
                    int Hexresnet3 = resultnet3;
                    int Hexresnet4 = resultnet4;
                    int Hexresbroad1 = resultbroad1;
                    int Hexresfirst4 = resultfirst4;
                    int Hexreslast4 = resultlast4;

                    String Hexresultnet1 = "00"+Integer.toHexString(Hexresnet1);
                    String Hexresultnet2 = "00"+Integer.toHexString(Hexresnet2);
                    String Hexresultnet3 = "00"+Integer.toHexString(Hexresnet3);
                    String Hexresultnet4 = "00"+Integer.toHexString(Hexresnet4);
                    String Hexresultbroad1 = "00"+Integer.toHexString(Hexresbroad1);
                    String Hexresultfirst4 = "00"+Integer.toHexString(Hexresfirst4);
                    String Hexresultlast4 = "00"+Integer.toHexString(Hexreslast4);

                    setHexNetwork.setText(Hexresultnet1.substring(Hexresultnet1.length()-2, Hexresultnet1.length())
                            + " : " + Hexresultnet2.substring(Hexresultnet2.length()-2, Hexresultnet2.length())
                            + " : " + Hexresultnet3.substring(Hexresultnet3.length()-2, Hexresultnet3.length())
                            + " : " + Hexresultnet4.substring(Hexresultnet4.length()-2, Hexresultnet4.length()));
                    setHexBroadcast.setText(Hexresultbroad1.substring(Hexresultbroad1.length()-2, Hexresultbroad1.length())
                            + " : " + Integer.toHexString(broadsolid)
                            + " : " + Integer.toHexString(broadsolid)
                            + " : " + Integer.toHexString(broadsolid));
                    setHexFirstAddress.setText(Hexresultnet1.substring(Hexresultnet1.length()-2, Hexresultnet1.length())
                            + " : " + Hexresultnet2.substring(Hexresultnet2.length()-2, Hexresultnet2.length())
                            + " : " + Hexresultnet3.substring(Hexresultnet3.length()-2, Hexresultnet3.length())
                            + " : " + Hexresultfirst4.substring(Hexresultfirst4.length()-2, Hexresultfirst4.length()));
                    setHexLastAddress.setText(Hexresultbroad1.substring(Hexresultbroad1.length()-2, Hexresultbroad1.length())
                            + " : " + Integer.toHexString(broadsolid)
                            + " : " + Integer.toHexString(broadsolid)
                            + " : " + Hexresultlast4.substring(Hexresultlast4.length()-2, Hexresultlast4.length()));
                    //16진수
                }

                 */
                if(cidr == 31){
                    int resultnet4 = s4 & input4z;
                    int resultbroad4 = resultnet4 + input4y -1;
                    int resultfirst4 = resultnet4 + 1;
                    int resultlast4 = resultbroad4 - 1;
                    subnettext.setText(broadsolid+" . "+broadsolid+" . "+broadsolid+" . "+ input4z);
                    setNetwork.setText(Integer.parseInt(input1.getText().toString())+" . "+Integer.parseInt(input2.getText().toString())+" . "+Integer.parseInt(input3.getText().toString())+" . "+resultnet4);
                    setBroadcast.setText(Integer.parseInt(input1.getText().toString())+" . "+Integer.parseInt(input2.getText().toString())+" . "+Integer.parseInt(input3.getText().toString())+" . "+ resultbroad4);
                    setFirstAddress.setText(Integer.parseInt(input1.getText().toString())+" . "+Integer.parseInt(input2.getText().toString())+" . "+Integer.parseInt(input3.getText().toString())+" . "+resultnet4);
                    setLastAddress.setText(Integer.parseInt(input1.getText().toString())+" . "+Integer.parseInt(input2.getText().toString())+" . "+Integer.parseInt(input3.getText().toString())+" . "+ resultbroad4);
                    //10진수

                    int binaryres1 = Integer.parseInt(input1.getText().toString());
                    int binaryres2 = Integer.parseInt(input2.getText().toString());
                    int binaryres3 = Integer.parseInt(input3.getText().toString());

                    int binaryresnet4 = resultnet4;
                    int binaryresbroad4 = resultbroad4;
                    int binaryresfirst4 = resultfirst4;
                    int binaryreslast4 = resultlast4;

                    String binaryresult1 = "00000000"+Integer.toBinaryString(binaryres1);
                    String binaryresult2 = "00000000"+Integer.toBinaryString(binaryres2);
                    String binaryresult3 = "00000000"+Integer.toBinaryString(binaryres3);

                    String binaryresultnet4 = "00000000"+Integer.toBinaryString(binaryresnet4);
                    String binaryresultbroad4 = "00000000"+Integer.toBinaryString(binaryresbroad4);
                    String binaryresultfirst4 = "00000000"+Integer.toBinaryString(binaryresfirst4);
                    String binaryresultlast4 = "00000000"+Integer.toBinaryString(binaryreslast4);

                    binarysetNetwork.setText(binaryresult1.substring(binaryresult1.length()-8, binaryresult1.length())
                            +" . "+binaryresult2.substring(binaryresult2.length()-8, binaryresult2.length())
                            +" . "+binaryresult3.substring(binaryresult3.length()-8, binaryresult3.length())
                            + " . "+binaryresultnet4.substring(binaryresultnet4.length()-8, binaryresultnet4.length()));
                    binarysetBroadcast.setText(binaryresult1.substring(binaryresult1.length()-8, binaryresult1.length())
                            +" . "+binaryresult2.substring(binaryresult2.length()-8, binaryresult2.length())
                            +" . "+binaryresult3.substring(binaryresult3.length()-8, binaryresult3.length())
                            +" . "+binaryresultbroad4.substring(binaryresultbroad4.length()-8, binaryresultbroad4.length()));
                    binarysetFirstAddress.setText(binaryresult1.substring(binaryresult1.length()-8, binaryresult1.length())
                            +" . "+binaryresult2.substring(binaryresult2.length()-8, binaryresult2.length())
                            +" . "+binaryresult3.substring(binaryresult3.length()-8, binaryresult3.length())
                            +" . "+binaryresultnet4.substring(binaryresultnet4.length()-8, binaryresultnet4.length()));
                    binarysetLastAddress.setText(binaryresult1.substring(binaryresult1.length()-8, binaryresult1.length())
                            +" . "+binaryresult2.substring(binaryresult2.length()-8, binaryresult2.length())
                            +" . "+binaryresult3.substring(binaryresult3.length()-8, binaryresult3.length())
                            +" . "+binaryresultbroad4.substring(binaryresultbroad4.length()-8, binaryresultbroad4.length()));
                    //2진수

                    int octalres1 = Integer.parseInt(input1.getText().toString());
                    int octalres2 = Integer.parseInt(input2.getText().toString());
                    int octalres3 = Integer.parseInt(input3.getText().toString());

                    setOctalNetwork.setText(Integer.toOctalString(octalres1)+" . "+Integer.toOctalString(octalres2)+" . "+Integer.toOctalString(octalres3)+" . "+Integer.toOctalString(resultnet4));
                    setOctalBroadcast.setText(Integer.toOctalString(octalres1)+" . "+Integer.toOctalString(octalres2)+" . "+Integer.toOctalString(octalres3)+" . "+Integer.toOctalString(resultbroad4));
                    setOctalFirstAddress.setText(Integer.toOctalString(octalres1)+" . "+Integer.toOctalString(octalres2)+" . "+Integer.toOctalString(octalres3)+" . "+Integer.toOctalString(resultnet4));
                    setOctalLastAddress.setText(Integer.toOctalString(octalres1)+" . "+Integer.toOctalString(octalres2)+" . "+Integer.toOctalString(octalres3)+" . "+Integer.toOctalString(resultbroad4));
                    //8진수

                    int Hexres1 = Integer.parseInt(input1.getText().toString());
                    int Hexres2 = Integer.parseInt(input2.getText().toString());
                    int Hexres3 = Integer.parseInt(input3.getText().toString());

                    int Hexresnet4 = resultnet4;
                    int Hexresbroad4 = resultbroad4;
                    int Hexresfirst4 = resultfirst4;
                    int Hexreslast4 = resultlast4;

                    String Hexresult1 = "00"+Integer.toHexString(Hexres1);
                    String Hexresult2 = "00"+Integer.toHexString(Hexres2);
                    String Hexresult3 = "00"+Integer.toHexString(Hexres3);

                    String Hexresultnet4 = "00"+Integer.toHexString(Hexresnet4);
                    String Hexresultbroad4 = "00"+Integer.toHexString(Hexresbroad4);
                    String Hexresultfirst4 = "00"+Integer.toHexString(Hexresfirst4);
                    String Hexresultlast4 = "00"+Integer.toHexString(Hexreslast4);

                    setHexNetwork.setText(Hexresult1.substring(Hexresult1.length()-2, Hexresult1.length())
                            +" : "+Hexresult2.substring(Hexresult2.length()-2, Hexresult2.length())
                            +" : "+Hexresult3.substring(Hexresult3.length()-2, Hexresult3.length())
                            +" : "+Hexresultnet4.substring(Hexresultnet4.length()-2, Hexresultnet4.length()));
                    setHexBroadcast.setText(Hexresult1.substring(Hexresult1.length()-2, Hexresult1.length())
                            +" : "+Hexresult2.substring(Hexresult2.length()-2, Hexresult2.length())
                            +" : "+Hexresult3.substring(Hexresult3.length()-2, Hexresult3.length())
                            +" : "+Hexresultbroad4.substring(Hexresultbroad4.length()-2, Hexresultbroad4.length()));
                    setHexFirstAddress.setText(Hexresult1.substring(Hexresult1.length()-2, Hexresult1.length())
                            +" : "+Hexresult2.substring(Hexresult2.length()-2, Hexresult2.length())
                            +" : "+Hexresult3.substring(Hexresult3.length()-2, Hexresult3.length())
                            +" : "+Hexresultnet4.substring(Hexresultnet4.length()-2, Hexresultnet4.length()));
                    setHexLastAddress.setText(Hexresult1.substring(Hexresult1.length()-2, Hexresult1.length())
                            +" : "+Hexresult2.substring(Hexresult2.length()-2, Hexresult2.length())
                            +" : "+Hexresult3.substring(Hexresult3.length()-2, Hexresult3.length())
                            +" : "+Hexresultbroad4.substring(Hexresultbroad4.length()-2, Hexresultbroad4.length()));
                    //16진수
                }

                if(cidr == 32){
                    int resultnet4 = s4 & input4z;
                    int resultbroad4 = resultnet4 + input4y -1;
                    int resultfirst4 = resultnet4 + 1;
                    int resultlast4 = resultbroad4 - 1;
                    subnettext.setText(broadsolid+" . "+broadsolid+" . "+broadsolid+" . "+ input4z);
                    setNetwork.setText(Integer.parseInt(input1.getText().toString())+" . "+Integer.parseInt(input2.getText().toString())+" . "+Integer.parseInt(input3.getText().toString())+" . "+resultnet4);
                    setBroadcast.setText(Integer.parseInt(input1.getText().toString())+" . "+Integer.parseInt(input2.getText().toString())+" . "+Integer.parseInt(input3.getText().toString())+" . "+ resultnet4);
                    setFirstAddress.setText(Integer.parseInt(input1.getText().toString())+" . "+Integer.parseInt(input2.getText().toString())+" . "+Integer.parseInt(input3.getText().toString())+" . "+resultnet4);
                    setLastAddress.setText(Integer.parseInt(input1.getText().toString())+" . "+Integer.parseInt(input2.getText().toString())+" . "+Integer.parseInt(input3.getText().toString())+" . "+ resultnet4);
                    //10진수

                    int binaryres1 = Integer.parseInt(input1.getText().toString());
                    int binaryres2 = Integer.parseInt(input2.getText().toString());
                    int binaryres3 = Integer.parseInt(input3.getText().toString());

                    int binaryresnet4 = resultnet4;
                    int binaryresbroad4 = resultbroad4;
                    int binaryresfirst4 = resultfirst4;
                    int binaryreslast4 = resultlast4;

                    String binaryresult1 = "00000000"+Integer.toBinaryString(binaryres1);
                    String binaryresult2 = "00000000"+Integer.toBinaryString(binaryres2);
                    String binaryresult3 = "00000000"+Integer.toBinaryString(binaryres3);

                    String binaryresultnet4 = "00000000"+Integer.toBinaryString(binaryresnet4);
                    String binaryresultbroad4 = "00000000"+Integer.toBinaryString(binaryresbroad4);
                    String binaryresultfirst4 = "00000000"+Integer.toBinaryString(binaryresfirst4);
                    String binaryresultlast4 = "00000000"+Integer.toBinaryString(binaryreslast4);

                    binarysetNetwork.setText(binaryresult1.substring(binaryresult1.length()-8, binaryresult1.length())
                            +" . "+binaryresult2.substring(binaryresult2.length()-8, binaryresult2.length())
                            +" . "+binaryresult3.substring(binaryresult3.length()-8, binaryresult3.length())
                            + " . "+binaryresultnet4.substring(binaryresultnet4.length()-8, binaryresultnet4.length()));
                    binarysetBroadcast.setText(binaryresult1.substring(binaryresult1.length()-8, binaryresult1.length())
                            +" . "+binaryresult2.substring(binaryresult2.length()-8, binaryresult2.length())
                            +" . "+binaryresult3.substring(binaryresult3.length()-8, binaryresult3.length())
                            +" . "+binaryresultnet4.substring(binaryresultnet4.length()-8, binaryresultnet4.length()));
                    binarysetFirstAddress.setText(binaryresult1.substring(binaryresult1.length()-8, binaryresult1.length())
                            +" . "+binaryresult2.substring(binaryresult2.length()-8, binaryresult2.length())
                            +" . "+binaryresult3.substring(binaryresult3.length()-8, binaryresult3.length())
                            +" . "+binaryresultnet4.substring(binaryresultnet4.length()-8, binaryresultnet4.length()));
                    binarysetLastAddress.setText(binaryresult1.substring(binaryresult1.length()-8, binaryresult1.length())
                            +" . "+binaryresult2.substring(binaryresult2.length()-8, binaryresult2.length())
                            +" . "+binaryresult3.substring(binaryresult3.length()-8, binaryresult3.length())
                            +" . "+binaryresultnet4.substring(binaryresultnet4.length()-8, binaryresultnet4.length()));
                    //2진수

                    int octalres1 = Integer.parseInt(input1.getText().toString());
                    int octalres2 = Integer.parseInt(input2.getText().toString());
                    int octalres3 = Integer.parseInt(input3.getText().toString());

                    setOctalNetwork.setText(Integer.toOctalString(octalres1)+" . "+Integer.toOctalString(octalres2)+" . "+Integer.toOctalString(octalres3)+" . "+Integer.toOctalString(resultnet4));
                    setOctalBroadcast.setText(Integer.toOctalString(octalres1)+" . "+Integer.toOctalString(octalres2)+" . "+Integer.toOctalString(octalres3)+" . "+Integer.toOctalString(resultnet4));
                    setOctalFirstAddress.setText(Integer.toOctalString(octalres1)+" . "+Integer.toOctalString(octalres2)+" . "+Integer.toOctalString(octalres3)+" . "+Integer.toOctalString(resultnet4));
                    setOctalLastAddress.setText(Integer.toOctalString(octalres1)+" . "+Integer.toOctalString(octalres2)+" . "+Integer.toOctalString(octalres3)+" . "+Integer.toOctalString(resultnet4));
                    //8진수

                    int Hexres1 = Integer.parseInt(input1.getText().toString());
                    int Hexres2 = Integer.parseInt(input2.getText().toString());
                    int Hexres3 = Integer.parseInt(input3.getText().toString());

                    int Hexresnet4 = resultnet4;
                    int Hexresbroad4 = resultbroad4;
                    int Hexresfirst4 = resultfirst4;
                    int Hexreslast4 = resultlast4;

                    String Hexresult1 = "00"+Integer.toHexString(Hexres1);
                    String Hexresult2 = "00"+Integer.toHexString(Hexres2);
                    String Hexresult3 = "00"+Integer.toHexString(Hexres3);

                    String Hexresultnet4 = "00"+Integer.toHexString(Hexresnet4);
                    String Hexresultbroad4 = "00"+Integer.toHexString(Hexresbroad4);
                    String Hexresultfirst4 = "00"+Integer.toHexString(Hexresfirst4);
                    String Hexresultlast4 = "00"+Integer.toHexString(Hexreslast4);

                    setHexNetwork.setText(Hexresult1.substring(Hexresult1.length()-2, Hexresult1.length())
                            +" : "+Hexresult2.substring(Hexresult2.length()-2, Hexresult2.length())
                            +" : "+Hexresult3.substring(Hexresult3.length()-2, Hexresult3.length())
                            +" : "+Hexresultnet4.substring(Hexresultnet4.length()-2, Hexresultnet4.length()));
                    setHexBroadcast.setText(Hexresult1.substring(Hexresult1.length()-2, Hexresult1.length())
                            +" : "+Hexresult2.substring(Hexresult2.length()-2, Hexresult2.length())
                            +" : "+Hexresult3.substring(Hexresult3.length()-2, Hexresult3.length())
                            +" : "+Hexresultnet4.substring(Hexresultnet4.length()-2, Hexresultnet4.length()));
                    setHexFirstAddress.setText(Hexresult1.substring(Hexresult1.length()-2, Hexresult1.length())
                            +" : "+Hexresult2.substring(Hexresult2.length()-2, Hexresult2.length())
                            +" : "+Hexresult3.substring(Hexresult3.length()-2, Hexresult3.length())
                            +" : "+Hexresultnet4.substring(Hexresultnet4.length()-2, Hexresultnet4.length()));
                    setHexLastAddress.setText(Hexresult1.substring(Hexresult1.length()-2, Hexresult1.length())
                            +" : "+Hexresult2.substring(Hexresult2.length()-2, Hexresult2.length())
                            +" : "+Hexresult3.substring(Hexresult3.length()-2, Hexresult3.length())
                            +" : "+Hexresultnet4.substring(Hexresultnet4.length()-2, Hexresultnet4.length()));
                    //16진수

                }



            }
        });

    }

}

