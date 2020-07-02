package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;

public class tablegrid extends AppCompatActivity {
EditText m1,m2,m3,m4,m5,m6,m7,m8;
    EditText t1,t2,t3,t4,t5,t6,t7,t8;
    TableRow r1,r2,r3;
    TableLayout l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablegrid);
        r1=findViewById(R.id.tr1);
        r2=findViewById(R.id.mon);
        r3=findViewById(R.id.tue);
        l=findViewById(R.id.tll);
        m1 = findViewById(R.id.mon1);
        m2 = findViewById(R.id.mon2);
        m3 = findViewById(R.id.mon3);
        m4 = findViewById(R.id.mon4);
        m5 = findViewById(R.id.mon5);
        m6 = findViewById(R.id.mon6);
        m7 = findViewById(R.id.mon7);
        m8 = findViewById(R.id.mon8);
        t1 = findViewById(R.id.tue1);
        t2 = findViewById(R.id.tue2);
        t3 = findViewById(R.id.tue3);
        t4 = findViewById(R.id.tue4);
        t5 = findViewById(R.id.tue5);
        t6 = findViewById(R.id.tue6);
        t7 = findViewById(R.id.tue7);
        t8 = findViewById(R.id.tue8);
        Intent i = getIntent();
        String msg = i.getStringExtra("ke");
        String msg1 = i.getStringExtra("ke1");
        String msg2 = i.getStringExtra("ke2");
        String msg3 = i.getStringExtra("ke3");
        String msg4 = i.getStringExtra("ke4");
//        r1= new TableRow(this);
//        r2=new TableRow(this);
//        r3=new TableRow(this);
//        l=new TableLayout(this);
        switch (msg)
        {
            case "Mon-Tue": {
                if (msg2 == "9:00A.M.-1:00P.M.")
                {
                    switch (msg1)
                    {
                        case "9:00A.M.-10:00A.M.":
                            {
                            m1.setText("Break");
                            t1.setText("Break");
                            break;
                        }
                        case "10:00A.M.-11:00A.M.": {
                            m2.setText("Break");
                            t2.setText("Break");
                            break;
                        }
                        case "11:00A.M.-12:00A.M.": {
                            m3.setText("Break");
                            t3.setText("Break");
                            break;
                        }
                        case "12:00A.M.-1:00P.M.": {
                            m4.setText("Break");
                            t4.setText("Break");
                            break;
                        }
                    }
                    m1.setText(msg3);
                    m2.setText(msg4);
                    t1.setText(msg4);
                    t2.setText(msg3);
                }
                else if (msg2 == "9:00A.M.-4:00P.M.")
                {
                    switch (msg1)
                    {
                        case "9:00A.M.-10:00A.M.":
                            {
                            m1.setText("Break");
                            t1.setText("Break");
                            break;
                        }
                        case "10:00A.M.-11:00A.M.": {
                            m2.setText("Break");
                            t2.setText("Break");
                            break;
                        }
                        case "11:00A.M.-12:00A.M.": {
                            m3.setText("Break");
                            t3.setText("Break");
                            break;
                        }
                        case "12:00A.M.-1:00P.M.": {
                            m4.setText("Break");
                            t4.setText("Break");
                            break;
                        }
                        case "1:00P.M.-2:00P.M.":
                        {
                            m5.setText("Break");
                            t5.setText("Break");
                            break;
                        }
                        case "2:00P.M.-3:00P.M.":
                        {
                            m6.setText("Break");
                            t6.setText("Break");
                            break;
                        }
                        case "3:00P.M.-4:00P.M.":
                        {
                            m7.setText("Break");
                            t7.setText("Break");
                            break;
                        }

                    }

                }
                else
                    {
                        switch (msg1) {
                            case "9:00A.M.-10:00A.M.": {
                                m1.setText("Break");
                                t1.setText("Break");
                                break;
                            }
                            case "10:00A.M.-11:00A.M.": {
                                m2.setText("Break");
                                t2.setText("Break");
                                break;
                            }
                            case "11:00A.M.-12:00A.M.": {
                                m3.setText("Break");
                                t3.setText("Break");
                                break;
                            }
                            case "12:00A.M.-1:00P.M.": {
                                m4.setText("Break");
                                t4.setText("Break");
                                break;
                            }
                            case "1:00P.M.-2:00P.M.":
                            {
                                m5.setText("Break");
                                t5.setText("Break");
                                break;
                            }
                            case "2:00P.M.-3:00P.M.":
                            {
                                m6.setText("Break");
                                t6.setText("Break");
                                break;
                            }
                            case "3:00P.M.-4:00P.M.":
                            {
                                m7.setText("Break");
                                t7.setText("Break");
                                break;
                            }
                            case "4:00P.M.-5:00P.M.":
                            {
                                m8.setText("Break");
                                t8.setText("Break");
                                break;
                            }
                        }

                    }
                break;
            }
            case "Mon-Wed": {
                if (msg2 == "9:00A.M.-1:00P.M.") {

                } else if (msg2 == "9:00A.M.-4:00P.M.") {

                } else {

                }
                break;
            }
            case "Mon-Thrus": {
                if (msg2 == "9:00A.M.-1:00P.M.") {

                } else if (msg2 == "9:00A.M.-4:00P.M.") {

                } else {

                }
                break;
            }
            case "Mon-Fri": {
                if (msg2 == "9:00A.M.-1:00P.M.") {

                } else if (msg2 == "9:00A.M.-4:00P.M.") {

                } else {

                }
                break;
            }

        }

    }
    }