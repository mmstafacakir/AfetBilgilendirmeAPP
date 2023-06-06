package com.samet.mobilproje;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.samet.mobilproje.databinding.ActivityStormsInfoPageBinding;

public class StormsInfoPage extends AppCompatActivity {

    ActivityStormsInfoPageBinding binding;
    private int currentIndex = 1;

    private String[] firtinaAn = {"Fırtına anında doğru önlemler almak, can güvenliğinizi sağlamak için önemlidir. Fırtına sırasında" +
            " aşağıdaki adımları izleyin:", "Güvenli Bir İç Mekâna Geçin: Hızla yaklaşan bir fırtına durumunda, dışarıda bulunmaktan" +
            " kaçının ve güvenli bir iç mekâna geçin. Bu, bir ev, apartman, işyeri veya diğer güvenli bir yapı olabilir.", "Pencereleri" +
            " ve Kapıları Kapatın: Evinizdeyseniz, pencereleri ve kapıları kapatın. Perdeleri çekerek camları koruyun. Fırtınanın şiddetiyle" +
            " camların kırılmasını engelleyebilirsiniz.", "İçeride Kalın: Fırtına sırasında dışarı çıkmayın. Dışarıda bulunan nesnelerin uçma" +
            " riski vardır ve size zarar verebilir. Güvende olmak için içeride kalın ve pencere yakınında veya cam altlarında durmayın."
            ,"Elektrik ve Gaz Bağlantılarını Kapatın: Fırtınanın şiddetiyle elektrik hatları zarar görebilir ve gaz sızıntıları oluşabilir." +
            " Fırtına sırasında elektrik ve gaz bağlantılarını kapatın. Bu, potansiyel tehlikeleri azaltmak için önemlidir.","Haberleri" +
            " Takip Edin: Radyo, televizyon veya akıllı telefon gibi haber kaynaklarını kullanarak yerel yetkililerin ve hava durumu" +
            " kurumunun verdiği bilgileri takip edin. Fırtına hakkında güncel bilgilere ulaşmak önemlidir.","Aydınlatma ve İletişim" +
            " Araçlarını Hazır Tutun: Fırtına sırasında elektrik kesintisi yaşanabilir. El fenerleri, pil ve şarj edilebilir radyolar" +
            " gibi aydınlatma ve iletişim araçlarını hazır tutun. Böylece haberlere ulaşabilir ve acil durumlarda iletişim kurabilirsiniz."
            ,"Tehlikeli Alanlardan Uzak Durun: Fırtına sırasında ağaçlar, direkler ve diğer yapısal unsurlar zarar görebilir veya" +
            " devrilebilir. Bu nedenle, fırtınanın etkisini azaltmak için tehlikeli alanlardan uzak durun.","Fırtına anında bu adımları" +
            " takip ederek, güvenliğinizi sağlayabilirsiniz. Her zaman yerel yetkililerin talimatlarını takip edin ve güvenlik önlemlerini" +
            " uygulayın."};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStormsInfoPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.infoText.setText(firtinaAn[0]);

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
        if (currentIndex < firtinaAn.length) {
            String currentString = firtinaAn[currentIndex];
            binding.infoText.setText(currentString);
            currentIndex++;
        } else {
            binding.infoText.setText("Dizi Sonuna Ulaşıldı");
        }
    }

    private void geri() {
        if (currentIndex > 0) {
            currentIndex--;
            String currentString = firtinaAn[currentIndex];
            binding.infoText.setText(currentString);
        } else {
            binding.infoText.setText("Dizi Başına Ulaşıldı");
        }
    }
}