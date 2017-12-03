import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;

import static org.junit.Assert.assertEquals;

public class Test2 {

    @Test
    public void test1() throws Exception {

        FileInputStream fis = new FileInputStream(new File("pub.key"));
        //FileReader fr = new FileReader(new File("pub.key"));
        byte[] chars = new byte[872];
        fis.read(chars);
        fis.close();

        String pubKey = new java.lang.String(chars);

        fis = new FileInputStream(new File("pri.key"));
        //FileReader fr = new FileReader(new File("pub.key"));
        chars = new byte[872];
        fis.read(chars);
        String priKey = new String(chars);
        fis.close();

        System.out.println(priKey);
        String key = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAJ/5priGS/Ma2Q2/o2JsqHUvMBSa\r\n" +
                "OPStU+gCaUsCzRy4UiP6su8CLdvn7r0ht/aoo/ukT6g5MD/jlcbdr8pSpF2/s+eiFteeU1F0q+hn\r\n" +
                "mHev6+LNh8f3R594VbV3X6syyrXS5Cnu57lBtHf92F/DTIbiLjmAS/oO+5nGz4AKskUPAgMBAAEC\r\n" +
                "gYAyMu/LFXE9vt3/f3QwjXIrG3yV6nMW7FDZC/Codh+Q9JHp8mA1udRUHip/NNZ6Ux7p9vx8CD4I\r\n" +
                "vkygk6326gnjVIbzraAKXTwBSj0sjq4+ji6C0R08o6vgND314+8lF0AJOiviVe50oeuwTAaF8yGl\r\n" +
                "krqyLzevBF5EiAXtFuAwoQJBAO1MRwzmAYYkprFqjz9hWz1kaL+VaHZ2TNaMEhMKQWSblge46fhc\r\n" +
                "+ZHGW+gdy1H+g2SWRF8Eta7GsS1P5r53SPECQQCslU9jNtYnPXyJ/LXvs8prhRySeJgU/wjcl262\r\n" +
                "PkWDeuQp3K6eXE85awBKkwHEpr/BKOgyfv7QWaUWsrXU8m3/AkEAlprEtUD9Up/MU+mnhLhLagli\r\n" +
                "GcW/iP/IAJrhlcf6fNnqPHh1tjV8B7L2/bh7JEz+I0bjmdKpZIWiSXnenp+iYQJAOYtfeRljtpnN\r\n" +
                "2MSmdVJhgBBWQpBrRTT0Y3kqtSF2VCy5vyuSHcNxtxdydWsm/8cJ0QIuygeGNzpszXCxKFvdSQJB\r\n" +
                "AJARoOAHLLnxSfKiBwYJysZVf/GqB/cGZN3hsSSBKVvW6oOtDZqyAabXrVi7pbrQojn4eb/i3tvu\r\n" +
                "bgfobN3Suss=\r\n";
        String key1 = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAJ/5priGS/Ma2Q2/o2JsqHUvMBSa\n" +
                "OPStU+gCaUsCzRy4UiP6su8CLdvn7r0ht/aoo/ukT6g5MD/jlcbdr8pSpF2/s+eiFteeU1F0q+hn\n" +
                "mHev6+LNh8f3R594VbV3X6syyrXS5Cnu57lBtHf92F/DTIbiLjmAS/oO+5nGz4AKskUPAgMBAAEC\n" +
                "gYAyMu/LFXE9vt3/f3QwjXIrG3yV6nMW7FDZC/Codh+Q9JHp8mA1udRUHip/NNZ6Ux7p9vx8CD4I\n" +
                "vkygk6326gnjVIbzraAKXTwBSj0sjq4+ji6C0R08o6vgND314+8lF0AJOiviVe50oeuwTAaF8yGl\n" +
                "krqyLzevBF5EiAXtFuAwoQJBAO1MRwzmAYYkprFqjz9hWz1kaL+VaHZ2TNaMEhMKQWSblge46fhc\n" +
                "+ZHGW+gdy1H+g2SWRF8Eta7GsS1P5r53SPECQQCslU9jNtYnPXyJ/LXvs8prhRySeJgU/wjcl262\n" +
                "PkWDeuQp3K6eXE85awBKkwHEpr/BKOgyfv7QWaUWsrXU8m3/AkEAlprEtUD9Up/MU+mnhLhLagli\n" +
                "GcW/iP/IAJrhlcf6fNnqPHh1tjV8B7L2/bh7JEz+I0bjmdKpZIWiSXnenp+iYQJAOYtfeRljtpnN\n" +
                "2MSmdVJhgBBWQpBrRTT0Y3kqtSF2VCy5vyuSHcNxtxdydWsm/8cJ0QIuygeGNzpszXCxKFvdSQJB\n" +
                "AJARoOAHLLnxSfKiBwYJysZVf/GqB/cGZN3hsSSBKVvW6oOtDZqyAabXrVi7pbrQojn4eb/i3tvu\n" +
                "bgfobN3Suss=\n";

        System.out.println(key1.length());
        System.out.println(key.length());
        System.out.println(key.equals(key1));
        System.out.println(key.equals(priKey));
        System.out.println(priKey.length());
        System.out.println(key1.equals(priKey));

 /*       String inputStr = "abc";
        byte[] data = inputStr.getBytes();

        byte[] encodedData = RSACoder.encryptByPublicKey(data, pubKey);

        byte[] decodedData = RSACoder.decryptByPrivateKey(encodedData,
                priKey);

        String outputStr = new String(decodedData);
        System.err.println("加密前: " + inputStr + "\n\r" + "解密后: " + outputStr);
        assertEquals(inputStr, outputStr);
*/

    }

    @Test
    public void test2() throws Exception {
        String key = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAJ/5priGS/Ma2Q2/o2JsqHUvMBSa\r\n" +
                "OPStU+gCaUsCzRy4UiP6su8CLdvn7r0ht/aoo/ukT6g5MD/jlcbdr8pSpF2/s+eiFteeU1F0q+hn\r\n" +
                "mHev6+LNh8f3R594VbV3X6syyrXS5Cnu57lBtHf92F/DTIbiLjmAS/oO+5nGz4AKskUPAgMBAAEC\r\n" +
                "gYAyMu/LFXE9vt3/f3QwjXIrG3yV6nMW7FDZC/Codh+Q9JHp8mA1udRUHip/NNZ6Ux7p9vx8CD4I\r\n" +
                "vkygk6326gnjVIbzraAKXTwBSj0sjq4+ji6C0R08o6vgND314+8lF0AJOiviVe50oeuwTAaF8yGl\r\n" +
                "krqyLzevBF5EiAXtFuAwoQJBAO1MRwzmAYYkprFqjz9hWz1kaL+VaHZ2TNaMEhMKQWSblge46fhc\r\n" +
                "+ZHGW+gdy1H+g2SWRF8Eta7GsS1P5r53SPECQQCslU9jNtYnPXyJ/LXvs8prhRySeJgU/wjcl262\r\n" +
                "PkWDeuQp3K6eXE85awBKkwHEpr/BKOgyfv7QWaUWsrXU8m3/AkEAlprEtUD9Up/MU+mnhLhLagli\r\n" +
                "GcW/iP/IAJrhlcf6fNnqPHh1tjV8B7L2/bh7JEz+I0bjmdKpZIWiSXnenp+iYQJAOYtfeRljtpnN\r\n" +
                "2MSmdVJhgBBWQpBrRTT0Y3kqtSF2VCy5vyuSHcNxtxdydWsm/8cJ0QIuygeGNzpszXCxKFvdSQJB\r\n" +
                "AJARoOAHLLnxSfKiBwYJysZVf/GqB/cGZN3hsSSBKVvW6oOtDZqyAabXrVi7pbrQojn4eb/i3tvu\r\n" +
                "bgfobN3Suss=\r\n";
        FileInputStream fis = new FileInputStream(new File("pub.key"));
        //FileReader fr = new FileReader(new File("pub.key"));
        byte[] chars = new byte[872];
        fis.read(chars);
        String pubKey = new java.lang.String(chars);
        fis.close();
        String inputStr = "abc";
        byte[] data = inputStr.getBytes();

        byte[] encodedData = RSACoder.encryptByPublicKey(data, pubKey);

        byte[] decodedData = RSACoder.decryptByPrivateKey(encodedData,
                key);

        String outputStr = new String(decodedData);
        System.err.println("加密前: " + inputStr + "\n\r" + "解密后: " + outputStr);
        assertEquals(inputStr, outputStr);
    }
}
