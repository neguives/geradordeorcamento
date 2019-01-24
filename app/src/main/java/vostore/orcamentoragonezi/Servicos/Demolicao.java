package vostore.orcamentoragonezi.Servicos;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import vostore.orcamentoragonezi.Main2Activity;
import vostore.orcamentoragonezi.Permissoes.PermissionsChecker;
import vostore.orcamentoragonezi.R;
import vostore.orcamentoragonezi.pdf.FileUtils;

import static vostore.orcamentoragonezi.pdf.LogUtils.LOGE;

public class Demolicao extends AppCompatActivity {


    private LinearLayout relativeLayout;
    private CheckBox checkBoxCozinha;
    private CheckBox checkBoxBanheiroSocial,checkBoxAreaServico,checkBoxBanheiroSuite,checkBoxLavabo,checkBoxSacadaVaranda,checkBoxSalaJantar,checkBoxSalaEstar,checkBoxQuartoSuite,checkBoxQuarto1,checkBoxQuarto2;
    private LinearLayout linearLayout1,linearLayout2,linearLayout3,linearLayout4,linearLayout5,linearLayout6,linearLayout7,linearLayout8,linearLayout9,linearLayout10,linearLayout11;
    private EditText valorRevestimentoParede1,valorRemocaoPiso,valorRemocaoPia,valorRemocacAlvenaria,valorRemocaoTanque,valorRasgarCaixinha4x2,valorRasgarCaixinha4x4,valorRasgarHidraulica,valorRemoverGesso,valorRemoverVaso,valorRemoverVao,
            valorRevestimentoParede2,valorRemocaoPiso2,valorRemocaoPia2,valorRemocacAlvenaria2,valorRemocaoTanque2,valorRasgarCaixinha4x2_2,valorRasgarCaixinha4x4_2,valorRasgarHidraulica2,valorRemoverGesso2,valorRemoverVaso2,valorRemoverVao2,
            valorRevestimentoParede3,valorRemocaoPiso3,valorRemocaoPia3,valorRemocacAlvenaria3,valorRemocaoTanque3,valorRasgarCaixinha4x2_3,valorRasgarCaixinha4x4_3,valorRasgarHidraulica3,valorRemoverGesso3,valorRemoverVaso3,valorRemoverVao3,
            valorRevestimentoParede4,valorRemocaoPiso4,valorRemocaoPia4,valorRemocacAlvenaria4,valorRemocaoTanque4,valorRasgarCaixinha4x2_4,valorRasgarCaixinha4x4_4,valorRasgarHidraulica4,valorRemoverGesso4,valorRemoverVaso4,valorRemoverVao4,
            valorRevestimentoParede5,valorRemocaoPiso5,valorRemocaoPia5,valorRemocacAlvenaria5,valorRemocaoTanque5,valorRasgarCaixinha4x2_5,valorRasgarCaixinha4x4_5,valorRasgarHidraulica5,valorRemoverGesso5,valorRemoverVaso5,valorRemoverVao5,
            valorRevestimentoParede6,valorRemocaoPiso6,valorRemocaoPia6,valorRemocacAlvenaria6,valorRemocaoTanque6,valorRasgarCaixinha4x2_6,valorRasgarCaixinha4x4_6,valorRasgarHidraulica6,valorRemoverGesso6,valorRemoverVaso6,valorRemoverVao6,
            valorRevestimentoParede7,valorRemocaoPiso7,valorRemocaoPia7,valorRemocacAlvenaria7,valorRemocaoTanque7,valorRasgarCaixinha4x2_7,valorRasgarCaixinha4x4_7,valorRasgarHidraulica7,valorRemoverGesso7,valorRemoverVaso7,valorRemoverVao7,
            valorRevestimentoParede8,valorRemocaoPiso8,valorRemocaoPia8,valorRemocacAlvenaria8,valorRemocaoTanque8,valorRasgarCaixinha4x2_8,valorRasgarCaixinha4x4_8,valorRasgarHidraulica8,valorRemoverGesso8,valorRemoverVaso8,valorRemoverVao8,
            valorRevestimentoParede9,valorRemocaoPiso9,valorRemocaoPia9,valorRemocacAlvenaria9,valorRemocaoTanque9,valorRasgarCaixinha4x2_9,valorRasgarCaixinha4x4_9,valorRasgarHidraulica9,valorRemoverGesso9,valorRemoverVaso9,valorRemoverVao9,
            valorRevestimentoParede10,valorRemocaoPiso10,valorRemocaoPia10,valorRemocacAlvenaria10,valorRemocaoTanque10,valorRasgarCaixinha4x2_10,valorRasgarCaixinha4x4_10,valorRasgarHidraulica10,valorRemoverGesso10,valorRemoverVaso10,valorRemoverVao10,
            valorRevestimentoParede11,valorRemocaoPiso11,valorRemocaoPia11,valorRemocacAlvenaria11,valorRemocaoTanque11,valorRasgarCaixinha4x2_11,valorRasgarCaixinha4x4_11,valorRasgarHidraulica11,valorRemoverGesso11,valorRemoverVaso11,valorRemoverVao11;
    private Button btn_finish;
    PermissionsChecker checker;
    Context mContext;
    double varRemoverRevestimentoParede2,varRemoverRevestimentoParede3,varRemoverRevestimentoParede4,varRemoverRevestimentoParede5,varRemoverRevestimentoParede6,varRemoverRevestimentoParede7,varRemoverRevestimentoParede8,varRemoverRevestimentoParede9,varRemoverRevestimentoParede10,varRemoverRevestimentoParede11;
    double precoRemoverRevestimentoParede = 30.00;
    double precoRemoverPiso = 30.00;
    double precoRemoverAlvenaria = 60.00;
    double   precoRemoverPia = 72.00;
    double   precoRemoverTanque = 52.00 ;
    double   precoRasgarCaixinha4x2 = 50.40;
    double   precoRasgarCaixinha4x4 = 54.40;
    double   precoRemoverVasoSanitario = 68.00;
    double   precoRemoverVao = 120.00;


    double varRemoverRevestimentoParede = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demolicao);

        mContext = getApplicationContext();

        checker = new PermissionsChecker(this);
        createPdf(FileUtils.getAppPath(mContext) + "123.pdf");
        //Botao Gerar Relatorio
        btn_finish = findViewById(R.id.demolicao_finish);
        relativeLayout = findViewById(R.id.layout_demolicao);

        //Fazendo cast/ instanciando os checklists aos seus respectivos views
        checkBoxCozinha = findViewById(R.id.checkbox_cozinha);
        checkBoxBanheiroSocial = findViewById(R.id.checkbox_banheiro_social);
        checkBoxBanheiroSuite = findViewById(R.id.checkbox_banheiro_suite);
        checkBoxAreaServico = findViewById(R.id.checkbox_areaservico);
        checkBoxLavabo = findViewById(R.id.checkbox_banheiro_lavabo);
        checkBoxSacadaVaranda = findViewById(R.id.checkbox_sacada);
        checkBoxSalaEstar = findViewById(R.id.checkbox_salaEstar);
        checkBoxSalaJantar = findViewById(R.id.checkbox_salaJantar);
        checkBoxQuarto1 = findViewById(R.id.checkbox_quarto1);
        checkBoxQuarto2 = findViewById(R.id.checkbox_quarto2);
        checkBoxQuartoSuite = findViewById(R.id.checkbox_quartoSuite);


        //Cast dos LinearLayouts
        linearLayout1 = findViewById(R.id.linearCozinha);
        linearLayout2 = findViewById(R.id.linearBanheiroSocial);
        linearLayout3 = findViewById(R.id.linearAreaServico);
        linearLayout4 = findViewById(R.id.linearBanheiroSuite);
        linearLayout5 = findViewById(R.id.linearLavabo);
        linearLayout6 = findViewById(R.id.linearSacada);
        linearLayout7 = findViewById(R.id.linearSalaJantar);
        linearLayout8 = findViewById(R.id.linearSalaEstar);
        linearLayout9 = findViewById(R.id.linearQuarto1);
        linearLayout10 = findViewById(R.id.linearQuarto2);
        linearLayout11 = findViewById(R.id.linearQuartoSuite);


        //Cast dos campos de valores


        //Revestimento Parede
        valorRevestimentoParede1 = findViewById(R.id.removerRevestimentoParede);
        valorRevestimentoParede3 = findViewById(R.id.removerRevestimentoParede3);
        valorRevestimentoParede4 = findViewById(R.id.removerRevestimentoParede4);
        valorRevestimentoParede5 = findViewById(R.id.removerRevestimentoParede5);
        valorRevestimentoParede6 = findViewById(R.id.removerRevestimentoParede6);
        valorRevestimentoParede7 = findViewById(R.id.removerRevestimentoParede7);
        valorRevestimentoParede8 = findViewById(R.id.removerRevestimentoParede8);
        valorRevestimentoParede9 = findViewById(R.id.removerRevestimentoParede9);
        valorRevestimentoParede10 = findViewById(R.id.removerRevestimentoParede10);
        valorRevestimentoParede11 = findViewById(R.id.removerRevestimentoParede11);

        //Remocao de Piso
        valorRemocaoPiso = findViewById(R.id.removerPiso);
        valorRemocaoPiso3= findViewById(R.id.removerPiso3);
        valorRemocaoPiso4= findViewById(R.id.removerPiso4);
        valorRemocaoPiso5 = findViewById(R.id.removerPiso5);
        valorRemocaoPiso6 = findViewById(R.id.removerPiso6);
        valorRemocaoPiso7 = findViewById(R.id.removerPiso7);
        valorRemocaoPiso8 = findViewById(R.id.removerPiso8);
        valorRemocaoPiso9 = findViewById(R.id.removerPiso9);
        valorRemocaoPiso10 = findViewById(R.id.removerPiso10);
        valorRemocaoPiso11 = findViewById(R.id.removerPiso11);

        //Remocao de Pia
        valorRemocaoPia = findViewById(R.id.removerPia);
        valorRemocaoPia3 = findViewById(R.id.removerPia3);
        valorRemocaoPia4 = findViewById(R.id.removerPia4);
        valorRemocaoPia5 = findViewById(R.id.removerPia5);
        valorRemocaoPia6 = findViewById(R.id.removerPia6);
        valorRemocaoPia7 = findViewById(R.id.removerPia7);
        valorRemocaoPia8 = findViewById(R.id.removerPia8);
        valorRemocaoPia9 = findViewById(R.id.removerPia9);
        valorRemocaoPia10 = findViewById(R.id.removerPia10);
        valorRemocaoPia11 = findViewById(R.id.removerPia11);

        //Remocao de Alvenaria
        valorRemocacAlvenaria = findViewById(R.id.removerAlvenaria);
        valorRemocacAlvenaria3 = findViewById(R.id.removerAlvenaria3);
        valorRemocacAlvenaria4 = findViewById(R.id.removerAlvenaria4);
        valorRemocacAlvenaria5 = findViewById(R.id.removerAlvenaria5);
        valorRemocacAlvenaria6 = findViewById(R.id.removerAlvenaria6);
        valorRemocacAlvenaria7 = findViewById(R.id.removerAlvenaria7);
        valorRemocacAlvenaria8 = findViewById(R.id.removerAlvenaria8);
        valorRemocacAlvenaria9 = findViewById(R.id.removerAlvenaria9);
        valorRemocacAlvenaria10 = findViewById(R.id.removerAlvenaria10);
        valorRemocacAlvenaria11 = findViewById(R.id.removerAlvenaria11);

        //Remover Tanque
        valorRemocaoTanque = findViewById(R.id.removerTanque);
        valorRemocaoTanque3 = findViewById(R.id.removerTanque3);
        valorRemocaoTanque4 = findViewById(R.id.removerTanque2);
        valorRemocaoTanque5 = findViewById(R.id.removerTanque5);
        valorRemocaoTanque6 = findViewById(R.id.removerTanque6);
        valorRemocaoTanque7 = findViewById(R.id.removerTanque7);
        valorRemocaoTanque8 = findViewById(R.id.removerTanque8);
        valorRemocaoTanque9 = findViewById(R.id.removerTanque9);
        valorRemocaoTanque10 = findViewById(R.id.removerTanque10);
        valorRemocaoTanque11 = findViewById(R.id.removerTanque11);

        //Rasgar Caixnha
        valorRasgarCaixinha4x2 = findViewById(R.id.rasgarCaixinha4x2);
        valorRasgarCaixinha4x2_3 = findViewById(R.id.rasgarCaixinha4x2_3);
        valorRasgarCaixinha4x2_4 = findViewById(R.id.rasgarCaixinha4x2_4);
        valorRasgarCaixinha4x2_5 = findViewById(R.id.rasgarCaixinha4x2_5);
        valorRasgarCaixinha4x2_6 = findViewById(R.id.rasgarCaixinha4x2_6);
        valorRasgarCaixinha4x2_7 = findViewById(R.id.rasgarCaixinha4x2_7);
        valorRasgarCaixinha4x2_8 = findViewById(R.id.rasgarCaixinha4x2_8);
        valorRasgarCaixinha4x2_9 = findViewById(R.id.rasgarCaixinha4x2_9);
        valorRasgarCaixinha4x2_10 = findViewById(R.id.rasgarCaixinha4x2_10);
        valorRasgarCaixinha4x2_11 = findViewById(R.id.rasgarCaixinha4x2_11);

        //Rasgar Caixinha 4x4

        valorRasgarCaixinha4x4 = findViewById(R.id.rasgarCaixinha4x4);
        valorRasgarCaixinha4x4_3 = findViewById(R.id.rasgarCaixinha4x4_3);
        valorRasgarCaixinha4x4_4 = findViewById(R.id.rasgarCaixinha4x4_4);
        valorRasgarCaixinha4x4_5 = findViewById(R.id.rasgarCaixinha4x4_5);
        valorRasgarCaixinha4x4_6 = findViewById(R.id.rasgarCaixinha4x4_6);
        valorRasgarCaixinha4x4_7 = findViewById(R.id.rasgarCaixinha4x4_7);
        valorRasgarCaixinha4x4_8 = findViewById(R.id.rasgarCaixinha4x4_8);
        valorRasgarCaixinha4x4_9 = findViewById(R.id.rasgarCaixinha4x4_9);
        valorRasgarCaixinha4x4_10 = findViewById(R.id.rasgarCaixinha4x4_10);
        valorRasgarCaixinha4x4_11 = findViewById(R.id.rasgarCaixinha4x4_11);

        //Rasgar Hidraulica
        valorRasgarHidraulica = findViewById(R.id.rasgarHidraulica);
        valorRasgarHidraulica3 = findViewById(R.id.rasgarHidraulica3);
        valorRasgarHidraulica4 = findViewById(R.id.rasgarHidraulica4);
        valorRasgarHidraulica5 = findViewById(R.id.rasgarHidraulica5);
        valorRasgarHidraulica6 = findViewById(R.id.rasgarHidraulica6);
        valorRasgarHidraulica7 = findViewById(R.id.rasgarHidraulica7);
        valorRasgarHidraulica8 = findViewById(R.id.rasgarHidraulica8);
        valorRasgarHidraulica9 = findViewById(R.id.rasgarHidraulica9);
        valorRasgarHidraulica10 = findViewById(R.id.rasgarHidraulica10);
        valorRasgarHidraulica11 = findViewById(R.id.rasgarHidraulica11);

        //Remocao Gesso

        valorRemoverGesso = findViewById(R.id.removerGesso);
        valorRemoverGesso3 = findViewById(R.id.removerGesso3);
        valorRemoverGesso4 = findViewById(R.id.removerGesso4);
        valorRemoverGesso5 = findViewById(R.id.removerGesso5);
        valorRemoverGesso6 = findViewById(R.id.removerGesso6);
        valorRemoverGesso7 = findViewById(R.id.removerGesso7);
        valorRemoverGesso8 = findViewById(R.id.removerGesso8);
        valorRemoverGesso9 = findViewById(R.id.removerGesso9);
        valorRemoverGesso10 = findViewById(R.id.removerGesso10);
        valorRemoverGesso11 = findViewById(R.id.removerGesso11);

        //Remocao Vaso Sanitario

        valorRemoverVaso = findViewById(R.id.removerGesso);
        valorRemoverVaso3 = findViewById(R.id.removerGesso3);
        valorRemoverVaso4 = findViewById(R.id.removerGesso4);
        valorRemoverVaso5 = findViewById(R.id.removerGesso5);
        valorRemoverVaso6 = findViewById(R.id.removerGesso6);
        valorRemoverVaso7 = findViewById(R.id.removerGesso7);
        valorRemoverVaso8 = findViewById(R.id.removerGesso8);
        valorRemoverVaso9 = findViewById(R.id.removerGesso9);
        valorRemoverVaso10 = findViewById(R.id.removerGesso10);
        valorRemoverVaso11 = findViewById(R.id.removerGesso11);

        //vao

        valorRemoverVao = findViewById(R.id.removerVao);
        valorRemoverVao3 = findViewById(R.id.removerVao3);
        valorRemoverVao4 = findViewById(R.id.removerVao4);
        valorRemoverVao5 = findViewById(R.id.removerVao5);
        valorRemoverVao6 = findViewById(R.id.removerVao6);
        valorRemoverVao7 = findViewById(R.id.removerVao7);
        valorRemoverVao8 = findViewById(R.id.removerVao8);
        valorRemoverVao9 = findViewById(R.id.removerVao9);
        valorRemoverVao10 = findViewById(R.id.removerVao10);
        valorRemoverVao11 = findViewById(R.id.removerVao11);







        //Exibir linear de acordo com a seleção do checkbox


        checkBoxCozinha.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    linearLayout3.setVisibility(View.VISIBLE);
                    checkBoxCozinha.setBackgroundColor(Color.parseColor("#1d1d1d"));

                    checkBoxCozinha.setTextColor(Color.parseColor("#ffffff"));

                    //Desativando os outros checkBox
                    checkBoxBanheiroSocial.setChecked(false);
                    checkBoxAreaServico.setChecked(false);
                    checkBoxBanheiroSuite.setChecked(false);
                    checkBoxLavabo.setChecked(false);
                    checkBoxQuarto1.setChecked(false);
                    checkBoxQuarto2.setChecked(false);
                    checkBoxQuartoSuite.setChecked(false);
                    checkBoxSacadaVaranda.setChecked(false);
                    checkBoxSalaEstar.setChecked(false);
                    checkBoxSalaJantar.setChecked(false);
                }else if (isChecked == false) {
                    linearLayout3.setVisibility(View.GONE);
                    checkBoxCozinha.setBackgroundResource(R.drawable.btn_servico1);

                }
            }});
        checkBoxBanheiroSocial.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    linearLayout2.setVisibility(View.VISIBLE);
                    checkBoxBanheiroSocial.setBackgroundColor(Color.parseColor("#1d1d1d"));

                    checkBoxBanheiroSocial.setTextColor(Color.parseColor("#ffffff"));



                    //Desativando os outros checkBox
                    checkBoxAreaServico.setChecked(false);
                    checkBoxBanheiroSuite.setChecked(false);
                    checkBoxLavabo.setChecked(false);
                    checkBoxQuarto1.setChecked(false);
                    checkBoxQuarto2.setChecked(false);
                    checkBoxQuartoSuite.setChecked(false);
                    checkBoxSacadaVaranda.setChecked(false);
                    checkBoxSalaEstar.setChecked(false);
                    checkBoxSalaJantar.setChecked(false);
                    checkBoxCozinha.setChecked(false);
                }else if (isChecked == false) {
                    linearLayout2.setVisibility(View.GONE);
                    checkBoxBanheiroSocial.setBackgroundResource(R.drawable.btn_servico1);

                }
            }});
        checkBoxAreaServico.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    linearLayout3.setVisibility(View.VISIBLE);
                    checkBoxAreaServico.setBackgroundColor(Color.parseColor("#1d1d1d"));

                    checkBoxAreaServico.setTextColor(Color.parseColor("#ffffff"));



                    //Desativando os outros checkBox
                    checkBoxBanheiroSocial.setChecked(false);
                    checkBoxBanheiroSuite.setChecked(false);
                    checkBoxLavabo.setChecked(false);
                    checkBoxQuarto1.setChecked(false);
                    checkBoxQuarto2.setChecked(false);
                    checkBoxQuartoSuite.setChecked(false);
                    checkBoxSacadaVaranda.setChecked(false);
                    checkBoxSalaEstar.setChecked(false);
                    checkBoxSalaJantar.setChecked(false);
                    checkBoxCozinha.setChecked(false);
                }else if (isChecked == false) {
                    linearLayout3.setVisibility(View.GONE);
                    checkBoxAreaServico.setBackgroundResource(R.drawable.btn_servico1);

                }
            }});
        checkBoxBanheiroSuite.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    linearLayout4.setVisibility(View.VISIBLE);
                    checkBoxBanheiroSuite.setBackgroundColor(Color.parseColor("#1d1d1d"));

                    checkBoxBanheiroSuite.setTextColor(Color.parseColor("#ffffff"));



                    //Desativando os outros checkBox
                    checkBoxBanheiroSocial.setChecked(false);
                    checkBoxAreaServico.setChecked(false);
                    checkBoxLavabo.setChecked(false);
                    checkBoxQuarto1.setChecked(false);
                    checkBoxQuarto2.setChecked(false);
                    checkBoxQuartoSuite.setChecked(false);
                    checkBoxSacadaVaranda.setChecked(false);
                    checkBoxSalaEstar.setChecked(false);
                    checkBoxSalaJantar.setChecked(false);
                    checkBoxCozinha.setChecked(false);
                }else if (isChecked == false) {
                    linearLayout4.setVisibility(View.GONE);
                    checkBoxBanheiroSuite.setBackgroundResource(R.drawable.btn_servico1);

                }
            }});

        checkBoxLavabo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    linearLayout5.setVisibility(View.VISIBLE);
                    checkBoxLavabo.setBackgroundColor(Color.parseColor("#1d1d1d"));

                    checkBoxLavabo.setTextColor(Color.parseColor("#ffffff"));



                    //Desativando os outros checkBox
                    checkBoxBanheiroSocial.setChecked(false);
                    checkBoxBanheiroSuite.setChecked(false);
                    checkBoxAreaServico.setChecked(false);
                    checkBoxQuarto1.setChecked(false);
                    checkBoxQuarto2.setChecked(false);
                    checkBoxQuartoSuite.setChecked(false);
                    checkBoxSacadaVaranda.setChecked(false);
                    checkBoxSalaEstar.setChecked(false);
                    checkBoxSalaJantar.setChecked(false);
                    checkBoxCozinha.setChecked(false);
                }else if (isChecked == false) {
                    linearLayout5.setVisibility(View.GONE);
                    checkBoxLavabo.setBackgroundResource(R.drawable.btn_servico1);

                }
            }});
        checkBoxSacadaVaranda.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    linearLayout6.setVisibility(View.VISIBLE);
                    checkBoxSacadaVaranda.setBackgroundColor(Color.parseColor("#1d1d1d"));

                    checkBoxSacadaVaranda.setTextColor(Color.parseColor("#ffffff"));



                    //Desativando os outros checkBox
                    checkBoxBanheiroSocial.setChecked(false);
                    checkBoxBanheiroSuite.setChecked(false);
                    checkBoxAreaServico.setChecked(false);
                    checkBoxQuarto1.setChecked(false);
                    checkBoxQuarto2.setChecked(false);
                    checkBoxQuartoSuite.setChecked(false);
                    checkBoxLavabo.setChecked(false);
                    checkBoxSalaEstar.setChecked(false);
                    checkBoxSalaJantar.setChecked(false);
                    checkBoxCozinha.setChecked(false);
                }else if (isChecked == false) {
                    linearLayout6.setVisibility(View.GONE);
                    checkBoxSacadaVaranda.setBackgroundResource(R.drawable.btn_servico1);

                }
            }});

        checkBoxSalaJantar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    linearLayout7.setVisibility(View.VISIBLE);
                    checkBoxSalaJantar.setBackgroundColor(Color.parseColor("#1d1d1d"));

                    checkBoxSalaJantar.setTextColor(Color.parseColor("#ffffff"));



                    //Desativando os outros checkBox
                    checkBoxBanheiroSocial.setChecked(false);
                    checkBoxBanheiroSuite.setChecked(false);
                    checkBoxAreaServico.setChecked(false);
                    checkBoxQuarto1.setChecked(false);
                    checkBoxQuarto2.setChecked(false);
                    checkBoxQuartoSuite.setChecked(false);
                    checkBoxLavabo.setChecked(false);
                    checkBoxSalaEstar.setChecked(false);
                    checkBoxSacadaVaranda.setChecked(false);
                    checkBoxCozinha.setChecked(false);
                }else if (isChecked == false) {
                    linearLayout7.setVisibility(View.GONE);
                    checkBoxSalaJantar.setBackgroundResource(R.drawable.btn_servico1);

                }
            }});

        checkBoxSalaEstar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    linearLayout8.setVisibility(View.VISIBLE);
                    checkBoxSalaEstar.setBackgroundColor(Color.parseColor("#1d1d1d"));

                    checkBoxSalaEstar.setTextColor(Color.parseColor("#ffffff"));



                    //Desativando os outros checkBox
                    checkBoxBanheiroSocial.setChecked(false);
                    checkBoxBanheiroSuite.setChecked(false);
                    checkBoxAreaServico.setChecked(false);
                    checkBoxQuarto1.setChecked(false);
                    checkBoxQuarto2.setChecked(false);
                    checkBoxQuartoSuite.setChecked(false);
                    checkBoxLavabo.setChecked(false);
                    checkBoxSalaJantar.setChecked(false);
                    checkBoxSacadaVaranda.setChecked(false);
                    checkBoxCozinha.setChecked(false);
                }else if (isChecked == false) {
                    linearLayout8.setVisibility(View.GONE);
                    checkBoxSalaEstar.setBackgroundResource(R.drawable.btn_servico1);

                }
            }});

        checkBoxQuartoSuite.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    linearLayout9.setVisibility(View.VISIBLE);
                    checkBoxQuartoSuite.setBackgroundColor(Color.parseColor("#1d1d1d"));

                    checkBoxQuartoSuite.setTextColor(Color.parseColor("#ffffff"));



                    //Desativando os outros checkBox
                    checkBoxBanheiroSocial.setChecked(false);
                    checkBoxBanheiroSuite.setChecked(false);
                    checkBoxAreaServico.setChecked(false);
                    checkBoxQuarto1.setChecked(false);
                    checkBoxQuarto2.setChecked(false);
                    checkBoxSalaEstar.setChecked(false);
                    checkBoxLavabo.setChecked(false);
                    checkBoxSalaJantar.setChecked(false);
                    checkBoxSacadaVaranda.setChecked(false);
                    checkBoxCozinha.setChecked(false);
                }else if (isChecked == false) {
                    linearLayout9.setVisibility(View.GONE);
                    checkBoxQuartoSuite.setBackgroundResource(R.drawable.btn_servico1);

                }
            }});

     checkBoxQuarto1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    linearLayout10.setVisibility(View.VISIBLE);
                    checkBoxQuarto1.setBackgroundColor(Color.parseColor("#1d1d1d"));

                    checkBoxQuarto1.setTextColor(Color.parseColor("#ffffff"));



                    //Desativando os outros checkBox
                    checkBoxBanheiroSocial.setChecked(false);
                    checkBoxBanheiroSuite.setChecked(false);
                    checkBoxAreaServico.setChecked(false);
                    checkBoxQuartoSuite.setChecked(false);
                    checkBoxQuarto2.setChecked(false);
                    checkBoxSalaEstar.setChecked(false);
                    checkBoxLavabo.setChecked(false);
                    checkBoxSalaJantar.setChecked(false);
                    checkBoxSacadaVaranda.setChecked(false);
                    checkBoxCozinha.setChecked(false);
                }else if (isChecked == false) {
                    linearLayout10.setVisibility(View.GONE);
                    checkBoxQuarto1.setBackgroundResource(R.drawable.btn_servico1);

                }
            }});

     checkBoxQuarto2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    linearLayout11.setVisibility(View.VISIBLE);
                    checkBoxQuarto2.setBackgroundColor(Color.parseColor("#1d1d1d"));

                    checkBoxQuarto2.setTextColor(Color.parseColor("#ffffff"));



                    //Desativando os outros checkBox
                    checkBoxBanheiroSocial.setChecked(false);
                    checkBoxBanheiroSuite.setChecked(false);
                    checkBoxAreaServico.setChecked(false);
                    checkBoxQuartoSuite.setChecked(false);
                    checkBoxQuarto1.setChecked(false);
                    checkBoxSalaEstar.setChecked(false);
                    checkBoxLavabo.setChecked(false);
                    checkBoxSalaJantar.setChecked(false);
                    checkBoxSacadaVaranda.setChecked(false);
                    checkBoxCozinha.setChecked(false);
                }else if (isChecked == false) {
                    linearLayout11.setVisibility(View.GONE);
                    checkBoxQuarto2.setBackgroundResource(R.drawable.btn_servico1);

                }
            }});




        btn_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //Calculando Valores Cozinha

                varRemoverRevestimentoParede = Double.parseDouble(valorRevestimentoParede1.getText().toString()) * precoRemoverRevestimentoParede;
                Double varRemoverPiso = Double.parseDouble(valorRemocaoPiso.getText().toString()) * precoRemoverPiso;
                double varRemoverPia = Integer.parseInt(valorRemocaoPia.getText().toString()) * precoRemoverPia;
                double varRemoverAlvenaria = Double.parseDouble(valorRemocacAlvenaria.getText().toString()) * precoRemoverAlvenaria;
                double varRemoverTanque = Integer.parseInt(valorRemocaoTanque.getText().toString()) * precoRemoverTanque;
                double  varRemoverCaixinha4x2 = Integer.parseInt(valorRasgarCaixinha4x2.getText().toString()) * precoRasgarCaixinha4x2;
                double  varRemoverCaixinha4x4 = Integer.parseInt(valorRasgarCaixinha4x4.getText().toString()) * precoRasgarCaixinha4x4;
                double varRemoverVasoSanitario = Integer.parseInt(valorRemoverVaso.getText().toString()) * precoRemoverVasoSanitario;
                double  varRemoverVao = Integer.parseInt(valorRemoverVao.getText().toString()) * precoRemoverVao;

                //Calculando Valores Remover Revestimento Parede

               /* varRemoverRevestimentoParede2 = Double.parseDouble(valorRevestimentoParede2.getText().toString()) * precoRemoverRevestimentoParede;
                Double varRemoverPiso2 = Double.parseDouble(valorRemocaoPiso2.getText().toString()) * precoRemoverPiso;
                double varRemoverPia2 = Integer.parseInt(valorRemocaoPia2.getText().toString()) * precoRemoverPia;
                double varRemoverAlvenaria2 = Double.parseDouble(valorRemocacAlvenaria2.getText().toString()) * precoRemoverAlvenaria;
                double  varRemoverTanque2 = Integer.parseInt(valorRemocaoTanque2.getText().toString()) * precoRemoverTanque;
                double  varRemoverCaixinha4x2_2 = Integer.parseInt(valorRasgarCaixinha4x2_2.getText().toString()) * precoRasgarCaixinha4x2;
                double  varRemoverCaixinha4x4_2 = Integer.parseInt(valorRasgarCaixinha4x4_2.getText().toString()) * precoRasgarCaixinha4x4;
                double  varRemoverVasoSanitario_2 = Integer.parseInt(valorRemoverVaso2.getText().toString()) * precoRemoverVasoSanitario;
                double  varRemoverVao_2 = Integer.parseInt(valorRemoverVao2.getText().toString()) * precoRemoverVao;


                //Calculando Valores Remover Revestimento Parede

                varRemoverRevestimentoParede3 = Double.parseDouble(valorRevestimentoParede3.getText().toString()) * precoRemoverRevestimentoParede;
                Double varRemoverPiso3 = Double.parseDouble(valorRemocaoPiso3.getText().toString()) * precoRemoverPiso;
                double varRemoverPia3 = Integer.parseInt(valorRemocaoPia3.getText().toString()) * precoRemoverPia;
                double varRemoverAlvenaria3 = Double.parseDouble(valorRemocacAlvenaria3.getText().toString()) * precoRemoverAlvenaria;
                double  varRemoverTanque3 = Integer.parseInt(valorRemocaoTanque3.getText().toString()) * precoRemoverTanque;
                double  varRemoverCaixinha4x2_3 = Integer.parseInt(valorRasgarCaixinha4x2_3.getText().toString()) * precoRasgarCaixinha4x2;
                double  varRemoverCaixinha4x4_3 = Integer.parseInt(valorRasgarCaixinha4x4_3.getText().toString()) * precoRasgarCaixinha4x4;
                double  varRemoverVasoSanitario_3 = Integer.parseInt(valorRemoverVaso3.getText().toString()) * precoRemoverVasoSanitario;
                double  varRemoverVao_3 = Integer.parseInt(valorRemoverVao3.getText().toString()) * precoRemoverVao;

                //Calculando Valores Cozinha

                varRemoverRevestimentoParede4 = Double.parseDouble(valorRevestimentoParede4.getText().toString()) * precoRemoverRevestimentoParede;
                Double varRemoverPiso4 = Double.parseDouble(valorRemocaoPiso4.getText().toString()) * precoRemoverPiso;
                double varRemoverPia4 = Integer.parseInt(valorRemocaoPia4.getText().toString()) * precoRemoverPia;
                double varRemoverAlvenaria4 = Double.parseDouble(valorRemocacAlvenaria4.getText().toString()) * precoRemoverAlvenaria;
                double  varRemoverTanque4 = Integer.parseInt(valorRemocaoTanque4.getText().toString()) * precoRemoverTanque;
                double  varRemoverCaixinha4x2_4 = Integer.parseInt(valorRasgarCaixinha4x2_4.getText().toString()) * precoRasgarCaixinha4x2;
                double  varRemoverCaixinha4x4_4 = Integer.parseInt(valorRasgarCaixinha4x4_4.getText().toString()) * precoRasgarCaixinha4x4;
                double  varRemoverVasoSanitario4 = Integer.parseInt(valorRemoverVaso4.getText().toString()) * precoRemoverVasoSanitario;
                double  varRemoverVao4 = Integer.parseInt(valorRemoverVao4.getText().toString()) * precoRemoverVao;


                //Calculando Valores Cozinha

                varRemoverRevestimentoParede5 = Double.parseDouble(valorRevestimentoParede5.getText().toString()) * precoRemoverRevestimentoParede;
                Double varRemoverPiso5 = Double.parseDouble(valorRemocaoPiso5.getText().toString()) * precoRemoverPiso;
                double varRemoverPia5 = Integer.parseInt(valorRemocaoPia5.getText().toString()) * precoRemoverPia;
                double varRemoverAlvenaria5 = Double.parseDouble(valorRemocacAlvenaria5.getText().toString()) * precoRemoverAlvenaria;
                double  varRemoverTanque5 = Integer.parseInt(valorRemocaoTanque5.getText().toString()) * precoRemoverTanque;
                double  varRemoverCaixinha4x2_5 = Integer.parseInt(valorRasgarCaixinha4x2_5.getText().toString()) * precoRasgarCaixinha4x2;
                double  varRemoverCaixinha4x4_5 = Integer.parseInt(valorRasgarCaixinha4x4_5.getText().toString()) * precoRasgarCaixinha4x4;
                double  varRemoverVasoSanitario5 = Integer.parseInt(valorRemoverVaso5.getText().toString()) * precoRemoverVasoSanitario;
                double  varRemoverVao5 = Integer.parseInt(valorRemoverVao5.getText().toString()) * precoRemoverVao;




                //Calculando Valores Cozinha

                varRemoverRevestimentoParede6 = Double.parseDouble(valorRevestimentoParede6.getText().toString()) * precoRemoverRevestimentoParede;
                Double varRemoverPiso6 = Double.parseDouble(valorRemocaoPiso6.getText().toString()) * precoRemoverPiso;
                double varRemoverPia6 = Integer.parseInt(valorRemocaoPia6.getText().toString()) * precoRemoverPia;
                double varRemoverAlvenaria6 = Double.parseDouble(valorRemocacAlvenaria6.getText().toString()) * precoRemoverAlvenaria;
                double  varRemoverTanque6 = Integer.parseInt(valorRemocaoTanque6.getText().toString()) * precoRemoverTanque;
                double  varRemoverCaixinha4x2_6 = Integer.parseInt(valorRasgarCaixinha4x2_6.getText().toString()) * precoRasgarCaixinha4x2;
                double  varRemoverCaixinha4x4_6 = Integer.parseInt(valorRasgarCaixinha4x4_6.getText().toString()) * precoRasgarCaixinha4x4;
                double  varRemoverVasoSanitario6 = Integer.parseInt(valorRemoverVaso6.getText().toString()) * precoRemoverVasoSanitario;
                double  varRemoverVao6 = Integer.parseInt(valorRemoverVao6.getText().toString()) * precoRemoverVao;



                //Calculando Valores Cozinha

                varRemoverRevestimentoParede7 = Double.parseDouble(valorRevestimentoParede7.getText().toString()) * precoRemoverRevestimentoParede;
                Double varRemoverPiso7 = Double.parseDouble(valorRemocaoPiso7.getText().toString()) * precoRemoverPiso;
                double varRemoverPia7 = Integer.parseInt(valorRemocaoPia7.getText().toString()) * precoRemoverPia;
                double varRemoverAlvenaria7 = Double.parseDouble(valorRemocacAlvenaria7.getText().toString()) * precoRemoverAlvenaria;
                double  varRemoverTanque7 = Integer.parseInt(valorRemocaoTanque7.getText().toString()) * precoRemoverTanque;
                double  varRemoverCaixinha4x2_7 = Integer.parseInt(valorRasgarCaixinha4x2_7.getText().toString()) * precoRasgarCaixinha4x2;
                double  varRemoverCaixinha4x4_7 = Integer.parseInt(valorRasgarCaixinha4x4_7.getText().toString()) * precoRasgarCaixinha4x4;
                double  varRemoverVasoSanitario7 = Integer.parseInt(valorRemoverVaso7.getText().toString()) * precoRemoverVasoSanitario;
                double  varRemoverVao7 = Integer.parseInt(valorRemoverVao7.getText().toString()) * precoRemoverVao;



                //Calculando Valores Cozinha

                varRemoverRevestimentoParede8 = Double.parseDouble(valorRevestimentoParede8.getText().toString()) * precoRemoverRevestimentoParede;
                Double varRemoverPiso8 = Double.parseDouble(valorRemocaoPiso8.getText().toString()) * precoRemoverPiso;
                double varRemoverPia8 = Integer.parseInt(valorRemocaoPia8.getText().toString()) * precoRemoverPia;
                double varRemoverAlvenaria8 = Double.parseDouble(valorRemocacAlvenaria8.getText().toString()) * precoRemoverAlvenaria;
                double  varRemoverTanque8 = Integer.parseInt(valorRemocaoTanque8.getText().toString()) * precoRemoverTanque;
                double  varRemoverCaixinha4x2_8 = Integer.parseInt(valorRasgarCaixinha4x2_8.getText().toString()) * precoRasgarCaixinha4x2;
                double  varRemoverCaixinha4x4_8 = Integer.parseInt(valorRasgarCaixinha4x4_8.getText().toString()) * precoRasgarCaixinha4x4;
                double  varRemoverVasoSanitario8 = Integer.parseInt(valorRemoverVaso8.getText().toString()) * precoRemoverVasoSanitario;
                double  varRemoverVao8 = Integer.parseInt(valorRemoverVao8.getText().toString()) * precoRemoverVao;



                //Calculando Valores Cozinha

                varRemoverRevestimentoParede9 = Double.parseDouble(valorRevestimentoParede9.getText().toString()) * precoRemoverRevestimentoParede;
                Double varRemoverPiso9 = Double.parseDouble(valorRemocaoPiso9.getText().toString()) * precoRemoverPiso;
                double varRemoverPia9 = Integer.parseInt(valorRemocaoPia9.getText().toString()) * precoRemoverPia;
                double varRemoverAlvenaria9 = Double.parseDouble(valorRemocacAlvenaria9.getText().toString()) * precoRemoverAlvenaria;
                double  varRemoverTanque9 = Integer.parseInt(valorRemocaoTanque9.getText().toString()) * precoRemoverTanque;
                double  varRemoverCaixinha4x2_9 = Integer.parseInt(valorRasgarCaixinha4x2_9.getText().toString()) * precoRasgarCaixinha4x2;
                double  varRemoverCaixinha4x4_9 = Integer.parseInt(valorRasgarCaixinha4x4_9.getText().toString()) * precoRasgarCaixinha4x4;
                double  varRemoverVasoSanitario9 = Integer.parseInt(valorRemoverVaso9.getText().toString()) * precoRemoverVasoSanitario;
                double  varRemoverVao9 = Integer.parseInt(valorRemoverVao9.getText().toString()) * precoRemoverVao;



                //Calculando Valores Cozinha

                varRemoverRevestimentoParede10 = Double.parseDouble(valorRevestimentoParede10.getText().toString()) * precoRemoverRevestimentoParede;
                Double varRemoverPiso10 = Double.parseDouble(valorRemocaoPiso10.getText().toString()) * precoRemoverPiso;
                double varRemoverPia10 = Integer.parseInt(valorRemocaoPia10.getText().toString()) * precoRemoverPia;
                double varRemoverAlvenaria10 = Double.parseDouble(valorRemocacAlvenaria10.getText().toString()) * precoRemoverAlvenaria;
                double  varRemoverTanque10 = Integer.parseInt(valorRemocaoTanque10.getText().toString()) * precoRemoverTanque;
                double  varRemoverCaixinha4x2_10 = Integer.parseInt(valorRasgarCaixinha4x2_10.getText().toString()) * precoRasgarCaixinha4x2;
                double  varRemoverCaixinha4x4_10 = Integer.parseInt(valorRasgarCaixinha4x4_10.getText().toString()) * precoRasgarCaixinha4x4;
                double  varRemoverVasoSanitario10 = Integer.parseInt(valorRemoverVaso10.getText().toString()) * precoRemoverVasoSanitario;
                double  varRemoverVao10 = Integer.parseInt(valorRemoverVao10.getText().toString()) * precoRemoverVao;




                //Calculando Valores Cozinha

                varRemoverRevestimentoParede11 = Double.parseDouble(valorRevestimentoParede11.getText().toString()) * precoRemoverRevestimentoParede;
                Double varRemoverPiso11 = Double.parseDouble(valorRemocaoPiso11.getText().toString()) * precoRemoverPiso;
                double varRemoverPia11 = Integer.parseInt(valorRemocaoPia11.getText().toString()) * precoRemoverPia;
                double varRemoverAlvenaria11 = Double.parseDouble(valorRemocacAlvenaria11.getText().toString()) * precoRemoverAlvenaria;
                double  varRemoverTanque11 = Integer.parseInt(valorRemocaoTanque11.getText().toString()) * precoRemoverTanque;
                double  varRemoverCaixinha4x2_11 = Integer.parseInt(valorRasgarCaixinha4x2_11.getText().toString()) * precoRasgarCaixinha4x2;
                double  varRemoverCaixinha4x4_11 = Integer.parseInt(valorRasgarCaixinha4x4_11.getText().toString()) * precoRasgarCaixinha4x4;
                double  varRemoverVasoSanitario_11 = Integer.parseInt(valorRemoverVaso11.getText().toString()) * precoRemoverVasoSanitario;
                double  varRemoverVao_11 = Integer.parseInt(valorRemoverVao11.getText().toString()) * precoRemoverVao;


 */



                double total = varRemoverRevestimentoParede + varRemoverPiso + varRemoverPia + varRemoverAlvenaria + varRemoverTanque + varRemoverCaixinha4x2 + varRemoverCaixinha4x4 + varRemoverVasoSanitario + varRemoverVao;
                Toast.makeText(mContext, "R$"+total, Toast.LENGTH_SHORT).show();


            }
        });

    }
    public void createPdf(String dest) {



        if (new File(dest).exists()) {

            new File(dest).delete();

        }



        try {

            /**

             * Creating Document

             */

            Document document = new Document();



            // Location to save

            PdfWriter.getInstance(document, new FileOutputStream(dest));



            // Open to write

            document.open();



            // Document Settings

            document.setPageSize(PageSize.A4);

            document.addCreationDate();

            document.addAuthor("Android School");

            document.addCreator("Pratik Butani");



            /***

             * Variables for further use....

             */

            BaseColor mColorAccent = new BaseColor(0, 153, 204, 255);

            float mHeadingFontSize = 20.0f;

            float mValueFontSize = 26.0f;



            /**

             * How to USE FONT....

             */

            BaseFont urName = BaseFont.createFont("assets/fonts/brandon_medium.otf", "UTF-8", BaseFont.EMBEDDED);



            // LINE SEPARATOR

            LineSeparator lineSeparator = new LineSeparator();

            lineSeparator.setLineColor(new BaseColor(0, 0, 0, 68));



            // Title Order Details...

            // Adding Title....

            Font mOrderDetailsTitleFont = new Font(urName, 36.0f, Font.NORMAL, BaseColor.BLACK);

            Chunk mOrderDetailsTitleChunk = new Chunk("Order Details", mOrderDetailsTitleFont);

            Paragraph mOrderDetailsTitleParagraph = new Paragraph(mOrderDetailsTitleChunk);

            mOrderDetailsTitleParagraph.setAlignment(Element.ALIGN_CENTER);

            document.add(mOrderDetailsTitleParagraph);



            // Fields of Order Details...

            // Adding Chunks for Title and value

            Font mOrderIdFont = new Font(urName, mHeadingFontSize, Font.NORMAL, mColorAccent);

            Chunk mOrderIdChunk = new Chunk("Order No:", mOrderIdFont);

            Paragraph mOrderIdParagraph = new Paragraph(mOrderIdChunk);

            document.add(mOrderIdParagraph);



            Font mOrderIdValueFont = new Font(urName, mValueFontSize, Font.NORMAL, BaseColor.BLACK);

            Chunk mOrderIdValueChunk = new Chunk("#123123", mOrderIdValueFont);

            Paragraph mOrderIdValueParagraph = new Paragraph(mOrderIdValueChunk);

            document.add(mOrderIdValueParagraph);



            // Adding Line Breakable Space....

            document.add(new Paragraph(""));

            // Adding Horizontal Line...

            document.add(new Chunk(lineSeparator));

            // Adding Line Breakable Space....

            document.add(new Paragraph(""));



            // Fields of Order Details...

            Font mOrderDateFont = new Font(urName, mHeadingFontSize, Font.NORMAL, mColorAccent);

            Chunk mOrderDateChunk = new Chunk("Order Date:", mOrderDateFont);

            Paragraph mOrderDateParagraph = new Paragraph(mOrderDateChunk);

            document.add(mOrderDateParagraph);



            Font mOrderDateValueFont = new Font(urName, mValueFontSize, Font.NORMAL, BaseColor.BLACK);

            Chunk mOrderDateValueChunk = new Chunk("06/07/2017", mOrderDateValueFont);

            Paragraph mOrderDateValueParagraph = new Paragraph(mOrderDateValueChunk);

            document.add(mOrderDateValueParagraph);



            document.add(new Paragraph(""));

            document.add(new Chunk(lineSeparator));

            document.add(new Paragraph(""));



            // Fields of Order Details...

            Font mOrderAcNameFont = new Font(urName, mHeadingFontSize, Font.NORMAL, mColorAccent);

            Chunk mOrderAcNameChunk = new Chunk("Account Name:", mOrderAcNameFont);

            Paragraph mOrderAcNameParagraph = new Paragraph(mOrderAcNameChunk);

            document.add(mOrderAcNameParagraph);



            Font mOrderAcNameValueFont = new Font(urName, mValueFontSize, Font.NORMAL, BaseColor.BLACK);

            Chunk mOrderAcNameValueChunk = new Chunk("Pratik Butani", mOrderAcNameValueFont);

            Paragraph mOrderAcNameValueParagraph = new Paragraph(mOrderAcNameValueChunk);

            document.add(mOrderAcNameValueParagraph);



            document.add(new Paragraph(""));

            document.add(new Chunk(lineSeparator));

            document.add(new Paragraph(""));



            document.close();



            Toast.makeText(this, "Created... :)", Toast.LENGTH_SHORT).show();



            FileUtils.openFile(mContext, new File(dest));



        } catch (IOException | DocumentException ie) {

            LOGE("createPdf: Error " + ie.getLocalizedMessage());

        } catch (ActivityNotFoundException ae) {

            Toast.makeText(this, "No application found to open this file.", Toast.LENGTH_SHORT).show();

        }

    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
        finish();
    }
}
