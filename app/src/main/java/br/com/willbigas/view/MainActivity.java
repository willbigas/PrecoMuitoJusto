package br.com.willbigas.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import br.com.willbigas.R;
import br.com.willbigas.controller.ProdutoController;
import br.com.willbigas.model.Produto;
import br.com.willbigas.util.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private ProdutoController produtoController;
    private Produto produto;

    private EditText edtNomeProduto;
    private EditText edtValorProduto;
    private EditText edtQuantidadeParcelas;
    private EditText edtJuros;

    private Button btnCalcular;
    private Button btnLimparDados;

    private TextView tvNomeProduto;
    private TextView tvValorInicial;
    private TextView tvValorParcelas;
    private TextView tvValorTotal;
    private TextView tvValorTotalJuros;

    private CheckBox checkComEntrada;

    private Boolean checkComEntradaFoiSelecionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        produtoController = new ProdutoController();


        edtNomeProduto = findViewById(R.id.edtNomeProduto);
        edtValorProduto = findViewById(R.id.edtValorProduto);
        edtQuantidadeParcelas = findViewById(R.id.edtQuantidadeParcelas);
        edtJuros = findViewById(R.id.edtJuros);

        btnCalcular = findViewById(R.id.btnCalcular);
        btnLimparDados = findViewById(R.id.btnLimparDados);

        tvNomeProduto = findViewById(R.id.tvNomeProduto);
        tvValorInicial = findViewById(R.id.tvValorInicial);
        tvValorParcelas = findViewById(R.id.tvValorParcelas);
        tvValorTotal = findViewById(R.id.tvValorTotal);
        tvValorTotalJuros = findViewById(R.id.tvValorTotalJuros);
        checkComEntrada = findViewById(R.id.checkComEntrada);
    }


    public void calcular(View view) {
        if (validarDadosDaView()) {
            receberDadosDaView();
            produto = produtoController.calcular(produto , checkComEntradaFoiSelecionado);
            exibirDadosNaView();
        }
    }

    public void limparDados(View view) {
        edtNomeProduto.setText("");
        edtValorProduto.setText("");
        edtQuantidadeParcelas.setText("");
        edtJuros.setText("");

        tvNomeProduto.setText("");
        tvValorInicial.setText("");
        tvValorParcelas.setText("");
        tvValorTotal.setText("");
        tvValorTotalJuros.setText("");
        checkComEntrada.setChecked(false);
    }

    private boolean validarDadosDaView() {
        boolean foiValidado = true;

        if (edtNomeProduto.getText().toString() == null || edtNomeProduto.getText().toString().equals("")) {
            edtNomeProduto.setError(getString(R.string.required_nomeProduto));
            foiValidado = false;
        }

        if (edtValorProduto.getText().toString() == null || edtValorProduto.getText().toString().equals("")) {
            edtValorProduto.setError(getString(R.string.required_valorProduto));
            foiValidado = false;
        }

        if (edtQuantidadeParcelas.getText().toString() == null || edtQuantidadeParcelas.getText().toString().equals("")) {
            edtQuantidadeParcelas.setError(getString(R.string.required_quantidadeParcelas));
            foiValidado = false;
        }

        if (edtJuros.getText().toString() == null || edtJuros.getText().toString().equals("")) {
            edtJuros.setError(getString(R.string.required_juros));
            foiValidado = false;
        }

        return foiValidado;
    }


    public void onCheckboxClicked(View view) {
       checkComEntradaFoiSelecionado = ((CheckBox) view).isChecked();
    }

    private void receberDadosDaView() {
        produto = new Produto(edtNomeProduto.getText().toString(),
                Double.valueOf(edtValorProduto.getText().toString()),
                Integer.valueOf(edtQuantidadeParcelas.getText().toString()),
                Double.valueOf(edtJuros.getText().toString()));
    }

    private void exibirDadosNaView() {
        tvNomeProduto.setText(produto.getNome());
        tvValorInicial.setText(DecimalFormat.deDecimalParaString(produto.getValorInicial()));
        tvValorParcelas.setText(DecimalFormat.deDecimalParaString(produto.getValorParcelas()));
        tvValorTotal.setText(DecimalFormat.deDecimalParaString(produto.getValorTotal()));
        tvValorTotalJuros.setText(DecimalFormat.deDecimalParaString(produto.getValorTotalJuros()));
    }
}
