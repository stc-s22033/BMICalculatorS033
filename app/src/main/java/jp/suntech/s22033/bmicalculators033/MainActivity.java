package jp.suntech.s22033.bmicalculators033;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.util.Output;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btKeisan = findViewById(R.id.btKeisan);
        Button btKuria = findViewById(R.id.btKuria);

        btKeisan.setOnClickListener(new KeiButtonClickListener());
        btKuria.setOnClickListener(new KuriButtonClickListener());
    }

    private class KeiButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            EditText age = findViewById(R.id.etAge);
            EditText sin = findViewById(R.id.etSintyo);
            EditText tai = findViewById(R.id.etTaijyu);
            TextView output = findViewById(R.id.tvOutput);

            String Age = age.getText().toString();
            String Sin = sin.getText().toString();
            String Tai = tai.getText().toString();
            int iAge = Integer.parseInt(Age);
            if (iAge < 16) {
                Dialog dialog = new Dialog();
                dialog.show(getSupportFragmentManager(), "Dialog");
            } else {
                float fTai = Float.parseFloat(Tai);
                float fSin = Float.parseFloat(Sin);
                float mSin = fSin / 100;
                float BMI = fTai / (mSin * mSin);
                String Teki = String.format("%.1f", mSin * mSin * 22);
                String Han;
                if (BMI < 18.5) {
                    Han = "低体重";
                    output.setText("あなたの肥満度は\n" + Han + "\nあなたの標準体重は\n" + Teki + "kg");
                } else if (BMI < 25) {
                    Han = "普通体重";
                    output.setText("あなたの肥満度は\n" + Han + "\nあなたの標準体重は\n" + Teki + "kg");
                } else if (BMI < 30) {
                    Han = "肥満（1度）";
                    output.setText("あなたの肥満度は\n" + Han + "\nあなたの標準体重は\n" + Teki + "kg");
                } else if (BMI < 35) {
                    Han = "肥満（2度）";
                    output.setText("あなたの肥満度は\n" + Han + "\nあなたの標準体重は\n" + Teki + "kg");
                } else if (BMI < 40) {
                    Han = "肥満（3度）";
                    output.setText("あなたの肥満度は\n" + Han + "\nあなたの標準体重は\n" + Teki + "kg");
                } else if (BMI >= 40) {
                    Han = "肥満（4度）";
                    output.setText("あなたの肥満度は\n" + Han + "\nあなたの標準体重は\n" + Teki + "kg");
                }
            }
        }
    }

    private class KuriButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            EditText age = findViewById(R.id.etAge);
            EditText sin = findViewById(R.id.etSintyo);
            EditText tai = findViewById(R.id.etTaijyu);
            TextView output = findViewById(R.id.tvOutput);

            age.setText("");
            sin.setText("");
            tai.setText("");
            output.setText("");
        }
    }
}