package com;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

 class menu
 {
    public static void main(String[] args) {
        List<String> menu = new ArrayList<>(Arrays.asList(
                "红烧鱼块","缸豆炒肉","莴苣炒肉","香干炒肉","莲藕炒肉","麻辣香锅",
                "粉蒸肉","苦瓜炒肉","酸菜鱼","青椒肉丝","花菜炒肉","四季豆炒肉",
                "蒜台炒肉","五花肉包菜","杏鲍菇炒肉","麻婆豆腐","鱿鱼圈辣椒洋葱",
                "炒肥肠","带鱼","鸭子烧萝卜","土豆烧鸡","豌豆胡萝卜肉丁","鱼汤",
                "蒸鱼","咖喱牛肉","羊肉胡萝卜煲","基围虾","剥皮鱼"
        ));

        List<String> jardiniere = new ArrayList<>(Arrays.asList(
                "生菜","菠菜","四季豆","土豆","莲藕","墨鱼丸","牛肉丸","羊肉卷","牛肉卷","金针菇","烤肠"
        ));

        selectRandomMenu(menu, jardiniere, 4);
    }

    private static void selectRandomMenu(List<String> menu, List<String> jardiniere, int numSelect) {
        Random random = new Random();
        for (int i = 0; i < numSelect; i++) {
            List<String> selectMenu = randomSelect(new ArrayList<>(menu), 3, random);

            for (String m : selectMenu) {
                menu.remove(m);
            }

            if (selectMenu.contains("麻辣香锅")) {
                List<String> selectJardiniere = randomSelect(new ArrayList<>(jardiniere), 7, random);
                System.out.println(String.format("Menu %d: %s + %s", i + 1, selectMenu, selectJardiniere));
            } else {
                System.out.println(String.format("Menu %d: %s", i + 1, selectMenu));
            }

            if (menu.size() < 3) {
                System.out.println("No enough menu left!");
                break;
            }
        }
    }

    private static List<String> randomSelect(List<String> list, int num, Random random) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            int index = random.nextInt(list.size());
            result.add(list.get(index));
            list.remove(index);
        }
        return result;
    }
}
