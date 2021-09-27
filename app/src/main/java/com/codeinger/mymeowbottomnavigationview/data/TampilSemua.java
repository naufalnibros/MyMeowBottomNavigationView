package com.codeinger.mymeowbottomnavigationview.data;

import com.google.gson.annotations.SerializedName;

public class TampilSemua {
    @SerializedName("judul_tugas")
    private String judulTugas;

    @SerializedName("pengajar_tugas")
    private String pengajarTugas;

    public String getJudulTugas() {
        return judulTugas;
    }

    public void setJudulTugas(String judulTugas) {
        this.judulTugas = judulTugas;
    }

    public String getPengajarTugas() {
        return pengajarTugas;
    }

    public void setPengajarTugas(String pengajarTugas) {
        this.pengajarTugas = pengajarTugas;
    }
}
