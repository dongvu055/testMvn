import java.io.*;

public class Module1 {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Module1 hello");
        File file = new File("D:\\testMvn\\Module1\\test.abc");
        FileInputStream fileInputStream = new FileInputStream(file);
        BufferedReader br = new BufferedReader(new FileReader(file));
        System.out.println(br.readLine());
        Source source = new Source();
        Properties propertiesRef = new Properties();
        Properties properties = new Properties();
        source.setProperties(propertiesRef);
        while (true) {
            long currentTime = System.currentTimeMillis();
            long modified = file.lastModified();
            if (currentTime == modified) {
                Thread.sleep(100);
                propertiesRef.setP1(String.valueOf(currentTime) + 1);
                propertiesRef.setP2(String.valueOf(currentTime) + 2);
                propertiesRef.setP3(3);
                propertiesRef.setP4(properties);
                System.out.println(source.getProperties().p1);
            }
        }
    }

    public static class Source {
        private Properties properties;

        public Properties getProperties() {
            return properties;
        }

        public void setProperties(Properties properties) {
            this.properties = properties;
        }
    }

    public static class Properties {
        private String p1;
        private String p2;
        private Integer p3;
        private Properties p4;

        public String getP1() {
            return p1;
        }

        public void setP1(String p1) {
            this.p1 = p1;
        }

        public String getP2() {
            return p2;
        }

        public void setP2(String p2) {
            this.p2 = p2;
        }

        public Integer getP3() {
            return p3;
        }

        public void setP3(Integer p3) {
            this.p3 = p3;
        }

        public Properties getP4() {
            return p4;
        }

        public void setP4(Properties p4) {
            this.p4 = p4;
        }
    }


    public void module1() {
        System.out.println("Dependency module1");
    }
}