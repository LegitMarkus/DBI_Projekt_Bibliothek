package at.htlleonding.logic;

import at.htlleonding.repository.CRUDOperations;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

@ApplicationScoped
public class LibraryMgmtLogic {
    @Inject
    protected EntityManager em;
    @Inject
    protected CRUDOperations crudOperations;

    @Transactional
    public void flushAndClear() {
        em.flush();
        em.clear();
    }
    public Date add2Weeks(Date date){
        date.setTime(date.getTime() + 1209600000);
        return date;
    }
    public static void WriteAllLines(String fileName, String line) throws IOException {
        File f = new File(fileName);
        if (f.exists()) {
            f.delete();
        }
        FileWriter writer = new FileWriter(fileName);
        f.createNewFile();

        writer.write(line);
        writer.close();
    }
}
