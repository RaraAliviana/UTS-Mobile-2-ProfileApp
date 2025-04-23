# Tugas Ujian Tengah Semester
Matakuliah Pemrograman Berbasis Mobile II
Aplikasi Profile App

Nama   : Rara Aliviana Gumaranti 
NIM    : 234311050
Kelas  : TRPL 4B


UTSProfileApp adalah aplikasi Android sederhana berbasis Jetpack Compose yang memungkinkan pengguna untuk **login**, **register**, **melihat data profil**, **update data**, dan **logout**. Aplikasi ini dibuat sebagai bagian dari tugas UTS mata kuliah Pemrograman Mobile II.

## Fitur Utama
- Login dan Register pengguna
- Tampilan profil pengguna setelah login
- Update data profil (nama, nomor HP, dan alamat)
- Logout dari aplikasi
- Desain modern menggunakan Material 3 + Jetpack Compose

### Struktur File

UTSProfileApp/
├── app/
│   ├── src/
│   │   └── main/
│   │       ├── java/
│   │       │   └── trpl/nim234311050/utsprofileapp/
│   │       │       ├── data/
│   │       │       │    ├── User.kt                   # Data class untuk menyimpan informasi user
│   │       │       │    ├── UserDao.kt                # Interface DAO untuk akses database user (insert, update, query)
│   │       │       │    └── UserDatabase.kt           # Room Database yang menyimpan data user
│   │       │       ├── ui/
│   │       │       │   ├── HomeScreen.kt            # UI utama setelah login
│   │       │       │   ├── LoginScreen.kt           # UI untuk login
│   │       │       │   ├── RegisterScreen.kt        # UI untuk registrasi
│   │       │       │   ├── UpdateProfileScreen.kt   # UI untuk update data user
│   │       │       │   └── theme/ 
│   │       │       │       └── Theme.kt             # Tema dan styling Material 3
│   │       │       ├── viewmodel/
│   │       │       │   └── UserViewModel.kt         # ViewModel untuk mengelola data user
│   │       │       └── MainActivity.kt              # Entry point aplikasi dan setup Navigation
│   │       └── res/
│   │           ├── layout/                          # (Kosong, karena pakai Compose)
│   │           └── values/
│   │               └── themes.xml                   # Tema dasar jika dibutuhkan
│   └── build.gradle
├── build.gradle (Project level)
├── settings.gradle
└── README.md                                        # Dokumentasi proyek
