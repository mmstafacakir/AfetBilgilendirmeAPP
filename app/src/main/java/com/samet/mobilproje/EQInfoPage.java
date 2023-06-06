package com.samet.mobilproje;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.samet.mobilproje.databinding.ActivityEqinfoPageBinding;

public class EQInfoPage extends AppCompatActivity {

    ActivityEqinfoPageBinding binding;
    private int currentIndex = 1;

    private String[] depremAn = {"Deprem anında doğru tepkiler vermek, hayatınızı ve sevdiklerinizi korumak için kritik öneme sahiptir." +
            " Bir deprem anında yapılması gerekenler şunlardır:", "Panik yapmayın ve sakin kalın. Sakin olmak, doğru kararlar almanıza" +
            " ve güvende kalmanıza yardımcı olur.", "Kendinizi hızla güvenli bir alana alın. Mümkünse, masa veya masanın altına sığının." +
            " Başınızı ve boynunuzu korumak için ellerinizi başınızın arkasına koyun.", "Pencerelerden ve cam eşyalardan uzak durun." +
            " Eğer mümkünse, kendinizi açık alanda veya duvarlardan uzakta tutun.","Asansörleri kullanmayın. Deprem sırasında asansörler" +
            " sıkışabilir veya enerji kesintisi olabilir. Merdivenleri kullanarak güvenli bir şekilde aşağıya inin.","Elektrik ve gazı" +
            " kapatın. Deprem sonrasında çıkabilecek yangın veya sızıntı riskini azaltmak için elektrik ve gaz bağlantılarını kapatın."
            ,"Açık alana çıkın. Eğer güvenli bir şekilde dışarı çıkabilirseniz, açık alanlarda bulunan toplanma noktalarına yönelin." +
            " Binalardan, elektrik direklerinden ve diğer potansiyel tehlikelerden uzak durun.","Komşularınıza ve diğer insanlara yardım" +
            " edin. Eğer güvendeyseniz, çevrenizdeki insanlara yardım etmek için elinizden geleni yapın. Özellikle yaşlılar, çocuklar" +
            " ve engelliler gibi daha savunmasız gruplara yardım etmeye çalışın.","Radyo veya televizyonu açın. Deprem sonrası haberleri" +
            " almak ve yetkililerin verdiği talimatları takip etmek için radyo veya televizyonu açık tutun.","Deprem anında bu önlemleri" +
            " alarak, kendinizi ve diğerlerini güvende tutabilirsiniz. Her zaman deprem hazırlıklarınızı gözden geçirin ve düzenli olarak" +
            " eğitim alın."};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEqinfoPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.infoText.setText(depremAn[0]);
        binding.btnMainPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainPage();
            }
        });

        binding.InfoPageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTransitionPage();
            }
        });

        binding.InfoPageSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSettingsPage();
            }
        });

        binding.infoNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ileri();
            }
        });

        binding.infoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                geri();
            }
        });

    }

    public void openTransitionPage(){
        Intent intent = new Intent(this, transitionPage.class);
        startActivity(intent);
    }
    public void openMainPage(){
        Intent intent = new Intent(this, MainPage.class);
        startActivity(intent);
    }

    public void openSettingsPage(){
        Intent intent = new Intent(this, settingsPage.class);
        startActivity(intent);
    }

    private void ileri() {
        if (currentIndex < depremAn.length) {
            String currentString = depremAn[currentIndex];
            binding.infoText.setText(currentString);
            currentIndex++;
        } else {
            binding.infoText.setText("Dizi Sonuna Ulaşıldı");
        }
    }

    private void geri() {
        if (currentIndex > 0) {
            currentIndex--;
            String currentString = depremAn[currentIndex];
            binding.infoText.setText(currentString);
        } else {
            binding.infoText.setText("Dizi Başına Ulaşıldı");
        }
    }
}