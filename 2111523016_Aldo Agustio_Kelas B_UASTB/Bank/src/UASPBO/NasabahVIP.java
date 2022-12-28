
package UASPBO;


public class NasabahVIP extends Nasabah {
    
        private double diskon;

        public NasabahVIP(String nama, String alamat, int noRekening, String saldo, double diskon) {
            super(nama, alamat, noRekening, saldo);
            this.diskon = diskon;
        }

        public double getDiskon() {
            return diskon;
        }

        public void setDiskon(double diskon) {
            this.diskon = diskon;
        }

        @Override
        public void tarikTunai(int jumlah, int jumlahSaldo) {
            double jumlahDiskon = jumlah * (1 - diskon / 100);
            super.tarikTunai(jumlah, jumlahSaldo);
        }
    
}
