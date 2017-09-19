package com.daogukeji.bluecard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.acs.bluetooth.BluetoothReader;
import com.acs.bluetooth.BluetoothReaderGattCallback;
import com.acs.bluetooth.BluetoothReaderManager;

public class MainActivity extends AppCompatActivity {

    private static final byte[] AUTO_POLLING_START = { (byte) 0xE0, 0x00, 0x00,
            0x40, 0x01 };
    public static final String EXTRAS_DEVICE_NAME = "DEVICE_NAME";
    public static final String EXTRAS_DEVICE_ADDRESS = "DEVICE_ADDRESS";

    TextView text;//显示。。。的地方
    TextView atr;
    EditText mEditMasterKey;//显示Authentication Key 的地方
    Button auth;
    Button startpoll;
    Button poweron;
    private BluetoothReader mBluetoothReader;
    private BluetoothReaderManager mBluetoothReaderManager;
    private BluetoothReaderGattCallback mGattCallback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView)findViewById(R.id.text);
        atr = (TextView) findViewById(R.id.atr);
        mEditMasterKey = (EditText) findViewById(R.id.editText_Master_Key);
        auth = (Button)findViewById(R.id.auth);
        startpoll = (Button)findViewById(R.id.startpoll);
        poweron = (Button)findViewById(R.id.poweron);


        //Authenticate按钮方法
        auth.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (mBluetoothReader == null) {
                    auth.setText("not readay");
                    return;
                }

                /* Retrieve master key from edit box. */
                byte masterKey[] = Utils.getEditTextinHexBytes(mEditMasterKey);

                if (masterKey != null && masterKey.length > 0) {
                    /* Clear response field for the result of authentication. */
                    text.setText("noData");

                    /* Start authentication. */
                    if (!mBluetoothReader.authenticate(masterKey)) {
                        text
                                .setText("card_reader_not_ready");
                    } else {
                        text.setText("Authenticating...");
                    }
                } else {
                    text.setText("Character format error!");
                }
            }
        });




        //Start Polling按钮方法
        startpoll.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (mBluetoothReader == null) {
                    atr.setText("card_reader_not_ready");
                    return;
                }
                if (!mBluetoothReader.transmitEscapeCommand(AUTO_POLLING_START)) {
                    atr.setText("card_reader_not_ready");
                }
            }
        });


        //Power On Card按钮方法
        poweron.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (mBluetoothReader == null) {
                    atr.setText("card_reader_not_ready");
                    return;
                }
                if (!mBluetoothReader.powerOnCard()) {
                    atr.setText("card_reader_not_ready");
                }
            }
        });
    }
}
