﻿# microservices-ecommerce
Microservices adalah cara membangun aplikasi dengan membaginya menjadi bagian-bagian kecil yang independen. Setiap bagian bertanggung jawab atas satu fungsi spesifik dan dapat berjalan sendiri.

Perbedaan dengan Monolithic:

Monolithic: Seperti rumah besar dengan semua ruangan tergabung - jika satu ruangan rusak, seluruh rumah terganggu
Microservices: Seperti kompleks perumahan dengan rumah-rumah kecil terpisah - jika satu rumah rusak, rumah lain tetap berfungsi normal
🏪 Real Case: Sistem E-Commerce
Kita akan membangun sistem e-commerce sederhana dengan komponen:

User Service: Mengelola data pelanggan (register, login, profil)
Product Service: Mengelola data produk (katalog, harga, stok)
API Gateway: Pintu masuk untuk semua request dari aplikasi web/mobile
Eureka Server: Direktori yang tahu dimana semua service berada
Skenario Penggunaan:

Customer buka aplikasi e-commerce
Aplikasi kirim request ke API Gateway
Gateway forward ke User Service untuk data profil
Gateway forward ke Product Service untuk data katalog
Semua data dikembalikan ke aplikasi customer
📁 Struktur Project
microservices-ecommerce/
├── eureka-server/          # Service Registry
├── api-gateway/           # Pintu masuk utama
├── user-service/          # Service untuk data user
└── product-service/       # Service untuk data produk
