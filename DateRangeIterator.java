import java.time.LocalDate;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DateRangeIterator implements Iterator<LocalDate> {
    LocalDate awal, akhir, sekarang;

    public DateRangeIterator(LocalDate awal, LocalDate akhir) {
        this.awal = awal;
        this.akhir = akhir;
        this.sekarang = awal;
    }

    public boolean hasNext() {
        return sekarang.plusDays(1).isBefore(akhir);
    }

    @Override
    public LocalDate next() {
        if (!hasNext())
            throw new NoSuchElementException();
        LocalDate now = this.sekarang;
        this.sekarang = this.sekarang.plusDays(1);
        return now;
    }

}
