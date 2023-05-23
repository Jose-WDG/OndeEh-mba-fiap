package br.com.ze.ondeeh.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.ze.ondeeh.databinding.ActivityAddressDetailBinding
import br.com.ze.ondeeh.model.Address
import br.com.ze.ondeeh.remote.APIService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddressDetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_CEP = "AddressDetailActivity.EXTRA_CEP"
    }

    private lateinit var binding: ActivityAddressDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =
            ActivityAddressDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setUpListener()
        search()
    }

    private fun setUpListener() {
        binding.btNew.setOnClickListener {
            val intent = Intent()
            setResult(RESULT_OK, intent)
            finish()
        }
    }

    private fun search() {
        val cep = intent.getStringExtra(EXTRA_CEP) ?: ""
        APIService
            .instance
            ?.search(cep)
            ?.enqueue(object : Callback<Address> {
                override fun onResponse(
                    call: Call<Address>, response:
                    Response<Address>
                ) {
                    if (response.isSuccessful) {
                        val endereco = response.body()
                        endereco?.let {
                            binding.tvStreetName.text = endereco.streetName
                            binding.tvDistrict.text = endereco.district
                            binding.tvStreetName.text =
                                endereco.streetName
                            binding.tvCity.text = endereco.city
                            binding.tvUF.text = endereco.uf
                        }
                    }
                }

                override fun onFailure(call: Call<Address>, t: Throwable) {
                    binding.tvStreetName.text = "CEP não encontrado"
                    binding.tvDistrict.text = ""
                    binding.tvStreetName.text = ""
                    binding.tvUF.text = ""
                }
            })
    }
}