package com.samet.mobilproje;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.samet.mobilproje.databinding.ActivityAvalancheInfoPageBinding;

public class AvalancheInfoPage extends AppCompatActivity {

    ActivityAvalancheInfoPageBinding binding;
    private int currentIndex = 1;

    private String[] cigAn = {"Çığ anında doğru tepkiler vermek, hayatta kalmanızı sağlamak için kritik önem taşır. İşte çığ anında" +
            " yapmanız gerekenler:", "Hareketinizi Sınırlayın: Çığın başlamasıyla birlikte hızla hareket eden bir kütlenin içinde" +
            " bulunabilirsiniz. Hareketinizi sınırlamak için çığın etkisi altında olabildiğince hızlı bir şekilde yanlara veya yukarıya" +
            " doğru hareket etmeye çalışın.", "Ağırlık Merkezini Düşürün: Çığ sırasında ağırlık merkezinizi düşürerek dengeyi koruyun." +
            " Dizlerinizi bükün ve ellerinizi başınızın üzerinde tutarak daha istikrarlı bir pozisyon alın. Ağırlığınızı ayaklarınıza" +
            " yayın ve kaymamak için mümkün olduğunca düşük bir pozisyonda kalın.", "Yüzeye Yakın Kalın: Eğer çığ altında kalırsanız," +
            " yüzeye yakın olabilmek için çabalar sarfedin. Sertleşmiş bir kar tabakasının üzerine doğru yüzeye çıkmanız hayati önem" +
            " taşır. Hareket edebiliyorsanız, tırmanma veya yüzme hareketleriyle kendinizi yüzeye yakın tutun.","Solunum Yollarını" +
            " Açık Tutun: Çığ altında kaldığınızda karın sertleşmesiyle hava alacak boşluklar oluşabilir. Solunum yollarınızı açık" +
            " tutmak için ağzınızı ve burnunuzu kapatın, nefes almak için küçük bir boşluk yaratın. Bu, havanın tükenmesini önler" +
            " ve daha fazla süreyle hayatta kalmanızı sağlar.","Kurtarma Çağrısı Yapın: Elinizdeyse, cep telefonunuzu kullanarak" +
            " kurtarma ekiplerine sinyal gönderin veya bir yardım çağrısı yapın. Sesi duyurabileceğiniz bir şekilde çığ altındaysanız," +
            " düzenli aralıklarla bağırarak yardım talep edin.","Sessiz Kalın: Çığ altında kaldıysanız, enerjinizi korumak için mümkün" +
            " olduğunca sessiz olun. Kendinizi hareket ettirmek yerine, kurtarma ekiplerinin sizi bulmasını sağlamak için sinyal" +
            " vermekle yetinin.","Çığ anında yapılması gerekenler oldukça önemlidir. Ancak çığ durumlarında profesyonel yardım almak" +
            " ve çığ eğitimi almış kişilere başvurmak en güvenli seçenek olacaktır."};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAvalancheInfoPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.infoText.setText(cigAn[0]);
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
        if (currentIndex < cigAn.length) {
            String currentString = cigAn[currentIndex];
            binding.infoText.setText(currentString);
            currentIndex++;
        } else {
            binding.infoText.setText("Dizi Sonuna Ulaşıldı");
        }
    }

    private void geri() {
        if (currentIndex > 0) {
            currentIndex--;
            String currentString = cigAn[currentIndex];
            binding.infoText.setText(currentString);
        } else {
            binding.infoText.setText("Dizi Başına Ulaşıldı");
        }
    }
}