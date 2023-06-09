package br.com.ze.ondeeh.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import br.com.ze.ondeeh.R
import br.com.ze.ondeeh.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val searchResult = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            //result.data?.getStringExtra("CHAVE")?.let {
            // result ->
            //}
            binding.etCep.setText("")
        } else {
            //No momento não teremos nenhuma interação caso
            //resultCode seja diferente de RESULT_OK
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setUpListener()
    }

    private fun setUpListener() {
        binding.btSearch.setOnClickListener {
            val searchIntent = Intent(
                this,
                AddressDetailActivity::class.java
            )
            searchIntent.putExtra(
                AddressDetailActivity.EXTRA_CEP,
                binding.etCep.text.toString()
            )
            searchResult.launch(searchIntent)
        }
    }
}