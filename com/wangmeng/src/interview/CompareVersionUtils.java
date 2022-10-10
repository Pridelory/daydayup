package interview;

/**
 * @ClassName CompareVersionUtils
 * @Description an util used to compare versions
 * @Author wangmeng
 * @Date 2022/10/3
 */
public class CompareVersionUtils {

    public static void main(String[] args) {
        int result = CompareVersionUtils.compareVersion("1.3.4.5", "1.3.4");
        System.out.println(result);
    }

    /**
     * Compare Version
     * @param version1
     * @param version2
     * @return an int variable
     */
    public static int compareVersion(String version1, String version2) {
        String[] version1Split = version1.split("\\.");
        String[] version2Split = version2.split("\\.");

        int maxLen = Math.max(version1Split.length, version2Split.length);
        for (int i = 0; i < maxLen; i++) {
            Integer version1Num = i < version1Split.length ? Integer.parseInt(version1Split[i]) : 0;
            Integer version2Num = i < version2Split.length ? Integer.parseInt(version2Split[i]) : 0;
            if (version1Num.intValue() != version2Num.intValue()) {
                return version1Num.intValue() > version2Num.intValue() ? 1 : -1;
            }
        }
        return 0;
    }
}
