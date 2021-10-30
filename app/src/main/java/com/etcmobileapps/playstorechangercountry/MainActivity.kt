package com.etcmobileapps.playstorechangercountry


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.etcmobileapps.playstorechangercountry.databinding.ActivityMainBinding


private  lateinit var binding: ActivityMainBinding

var currentLangue: String = "en";
var currentCountry: String = "us";
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }


    override fun onStart () {
        super.onStart()
        setSpinners()
        launchBrowser("https://play.google.com/store/apps/top?hl=tr&gl=US")
    }

    fun setSpinners() {

        // access the items of the list
        val languages = resources.getStringArray(R.array.Languages)

        // access the spinner
        val spinnerLangu = findViewById<Spinner>(R.id.spinnerLangu)
        if (spinnerLangu != null) {
            val adapter = ArrayAdapter(this,
                android.R.layout.simple_spinner_item, languages)
            spinnerLangu.adapter = adapter

            spinnerLangu.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>,
                                            view: View, position: Int, id: Long) {

                    currentLangue=languages[position].toString();
                    changeSetings(currentLangue, currentCountry)
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }



        // access the items of the list
        val countries = resources.getStringArray(R.array.freeCountry)

        // access the spinner
        val spinnerCountry = findViewById<Spinner>(R.id.spinnerCountry)
        if (spinnerCountry != null) {
            val adapter = ArrayAdapter(this,
                android.R.layout.simple_spinner_item, countries)
            spinnerCountry.adapter = adapter

            spinnerCountry.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>,
                                            view: View, position: Int, id: Long) {

                    currentCountry=countries[position].toString();
                    changeSetings(currentLangue, currentCountry)

                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }

    }
    override fun onBackPressed() {
        if (binding.webView.canGoBack()) {
            binding.webView.goBack()
        } else {
            super.onBackPressed()
        }
    }

    fun launchBrowser(url :String) {
        binding.webView.settings.setJavaScriptEnabled(true)
        binding.webView.loadUrl(url)
    }


    fun changeSetings (langue : String,country: String) {
        var currentUrl =  binding.webView.url
            val defaultUrl: String = removeLastChars(currentUrl.toString(),12)!!
        Toast.makeText(MainActivity@this, defaultUrl.toString(), Toast.LENGTH_SHORT).show()

        binding.webView.loadUrl(defaultUrl+"?hl="+ langue + "&gl=" + country)

    }

    }

fun removeLastChars(str: String, chars: Int): String? {
    return str.substring(0, str.length - chars)
}