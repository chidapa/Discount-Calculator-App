package th.ac.su.ict.chidapa.discountcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.widget.Button
//import sun.jvm.hotspot.utilities.IntArray



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var edtOriginalPrice = findViewById<EditText>(R.id.edtOriginalPrice);
        var edtPercentOff = findViewById<EditText>(R.id.edtPercentOff);
        var cbTax = findViewById<CheckBox>(R.id.cbTax);
        var btnCalculate = findViewById<Button>(R.id.btnCalculate);
        var tvPrice = findViewById<EditText>(R.id.tvPrice);

        btnCalculate.setOnClickListener {

            if (cbTax.isChecked) {
                var original = edtOriginalPrice.text.toString().toDouble()
                var disc = edtPercentOff.text.toString().toDouble()

                var finalPrice = (original - (original * (disc / 100)))

                if (cbTax.isChecked) {
                    finalPrice += ((finalPrice * 7) / 100)
                }
                tvPrice.setText(finalPrice.toString())
            }

        }
    }
}
