package com.android.tugasakhir.model;

import java.util.List;

public class MainModel {


        private List<Result> result;

        public List<Result> getResult() {
            return result;
        }

        public void setResult(List<Result> result) {
            this.result = result;
        }
    public class Result {

        private int id;
        private String title;
        private String description;
        private String kategori;
        private String lokasi;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getKategori() {
            return kategori;
        }

        public void setKategori(String kategori) {
            this.kategori = kategori;
        }

        public String getLokasi() {
            return lokasi;
        }

        public void setLokasi(String lokasi) {
            this.lokasi = lokasi;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        private String image;

        @Override
        public String toString() {
            return "Result{" +
                    "id=" + id +
                    ", name='" + title + '\'' +
                    ", description='" + description + '\'' +
                    ", kategori='" + kategori + '\'' +
                    ", lokasi='" + lokasi + '\'' +
                    ", image='" + image + '\'' +
                    '}';
        }
    }
}
