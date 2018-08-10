import java.util.Scanner;

/*
 * �Ի����˶���ϵͳ
 * @author KUKE
*/
public class OrderingMsg2 {
	public static void main(String[] args) {
		// �������壺һ�鶩����Ϣ
		String[] names = new String[4]; // ������
		String[] dishMegs = new String[4]; // ������Ʒ
		int[] times = new int[4]; // �Ͳ�ʱ��
		String[] addresses = new String[4]; // �Ͳ͵�ַ
		int[] states = new int[4]; // ����״̬ 0: ��Ԥ�� 1:�����
		double[] sumPrices = new double[4]; // �ܽ��

		// ��ʼ��2��������Ϣ
		names[0] = "����";
		dishMegs[0] = "������˿ 1��";
		times[0] = 12;
		addresses[0] = "���·209��";
		states[0] = 0;
		sumPrices[0] = 24.0;

		names[1] = "����";
		dishMegs[1] = "���մ��� 2��";
		times[1] = 12;
		addresses[1] = "���·209��";
		states[1] = 1;
		sumPrices[1] = 76.0;

		// �������壺һ���Ʒ��Ϣ
		String[] dishNames = { "���մ���", "������˿", "ʱ���߲�" };
		double[] prices = new double[] { 38.0, 18.0, 10.0 };
		int[] praiseNums = new int[3];

		Scanner input = new Scanner(System.in);
		// ѭ�� ( do-while )

		int num = -2; // ��¼�û����������
		do {
			// ѭ��������
			// ��ʾ���˵�
			System.out.println("********************");
			System.out.println("1.��Ҫ���");
			System.out.println("2.�鿴�ʹ�");
			System.out.println("3.ǩ�ն���");
			System.out.println("4.ɾ������");
			System.out.println("5.��Ҫ����");
			System.out.println("6.�˳�ϵͳ");
			System.out.println("********************");

			System.out.print("��ѡ��:");
			int choose = input.nextInt(); // ��¼�û�ѡ��Ĺ��ܱ��

			boolean isAdd = false; // true:��¼�ҵ�һ��Ϊ�յ�λ�ã����Բ���false��û���ҵ�
			// ��ʾ�û��鹦�ܱ�ţ� ��ִ����Ӧ����
			switch (choose) {
			case 1:
				// 1.��Ҫ����
				System.out.println("*******��Ҫ����*******");
				// 1.����Ҫ�����λ��
				for (int i = 0; i < names.length; i++) {
					// ����ҵ�Ϊ�յ�λ�ã���¼����
					if (names[i] == null) {
						isAdd = true; // ��¼���ҵ�һ��Ϊ�յ�λ��
						// ִ�в������
						// a.��ʾ���пɹ�ѡ��Ĳ�Ʒ��Ϣ
						System.out.println("���\t��Ʒ��\t����\t������");
						for (int j = 0; j < dishNames.length; j++) {
							String price = prices[j] + "Ԫ";
							String praise = praiseNums[j] + "��";
							System.out.println((j + 1) + "\t" + dishNames[j] + "\t" + price + "\t" + praise);
						}

						// ������ѡ��Ʒ�ı�źͷ���
						System.out.print("��ѡ��������Ʒ��ţ�");
						int chooseDish = input.nextInt();
						System.out.print("��ѡ����������");
						int number = input.nextInt();
						String dishMeg = dishNames[chooseDish - 1] + " " + number + "��";

						// b.���붩��������
						System.out.print("�����붩��������");
						String name = input.next();

						// c.�����Ͳ�ʱ��
						System.out.print("�������Ͳ�ʱ��(10-20����)��");
						int time = input.nextInt();

						// ���������ˣ��ظ�����
						while (time < 10 || time > 20) {
							System.out.print("�Բ�������������������10-20֮�������");
							time = input.nextInt();
						}

						// d.�����Ͳ͵�ַ
						System.out.print("�������Ͳ͵�ַ��");
						String address = input.next();

						// e.����ͷ�
						double sumPrice = prices[chooseDish - 1];
						// �Ͳͷѣ����ͷѴﵽ50Ԫʱ����6Ԫ�Ͳͷ�
						double deliCharge = sumPrice >= 0 ? 0.0 : 6.0;

						// ��ʾ������Ϣ
						System.out.println("���ͳɹ�!");
						System.out.println("�������ǣ�" + dishMeg);
						System.out.println("�����ˣ�" + name);
						System.out.println("�Ͳ�ʱ�䣺" + time + "��");
						System.out.println("�Ͳ͵�ַ��" + address);
						System.out.println("�ͷѣ�" + sumPrice + ",�Ͳͷѣ�" + deliCharge + "Ԫ");
						System.out.println("�ܽ�" + (sumPrice + deliCharge) + "Ԫ");

						// ��������
						names[i] = name;
						dishMegs[i] = dishMeg;
						times[i] = time;
						addresses[i] = address;
						sumPrices[i] = sumPrice + deliCharge;

						break;
					}
				}
				// ���û���ҵ�Ϊ�յ�λ�ã�����ʾ��Ϣ
				if (!isAdd) {
					System.out.println("�Բ������Ĳʹ�������");
				}
				break;
			case 2:
				// 2.�鿴�ʹ�
				System.out.println("******�鿴�ʹ�*********");
				System.out.println("���\t������\t��Ԥ����Ʒ��Ϣ\t�Ͳ�ʱ��\t�Ͳ͵�ַ\t\t���\t״̬");
				// ��������
				for (int i = 0; i < names.length; i++) {
					if (names[i] != null) {
						String timeString = times[i] + "��";
						String sumPrice = sumPrices[i] + "Ԫ";
						String state = (states[i] == 0) ? "��Ԥ��" : "�����";
						System.out.println((i + 1) + "\t" + names[i] + "\t" + dishMegs[i] + "\t" + times[i] + "\t"
								+ addresses[i] + "\t" + sumPrice + "\t" + state);
					}
				}

				break;
			case 3:
				// 3.ǩ�ն���
				System.out.println("********ǩ�ն���**********");
				// Ҫ���û�����һ��ǩ�յĶ������
				System.out.print("ǿ����Ҫǩ�յĶ�����ţ�");
				int singOrderId = input.nextInt();
				boolean isFand = false; // ��¼�Ƿ��ҵ��������� ture�����ҵ� false��û�ҵ�
				// �������������ǣ�ѭ��������
				for (int i = 0; i < names.length; i++) {
					// 1���ҵ���״̬ʱ����ɣ��Ѿ����ǩ�գ�����ʾ�����ٴ�ǩ��
					// 2���ҵ���״̬����Ԥ����û�����ǩ�գ�������ǩ��
					if (names[i] != null && states[i] == 1 && singOrderId == i + 1) {
						System.out.println("�Բ�����ѡ��Ķ����Ѿ����ǩ�գ������ٴ�ǩ�գ�");
						isFand = true;
						break;
					} else if (names[i] != null && states[i] == 0 && singOrderId == i + 1) {
						states[i] = 1; // ״̬�Ѹ�Ϊ�����״̬
						System.out.println("����ǩ�ճɹ���");
						isFand = true;
						break;
					}
				}
				// �����жϣ����û���ҵ�������������ȥ��ʾû���ҵ�
				// 3��û�ҵ�����ʾ��Ϣû���ҵ�
				if (!isFand) {
					System.out.println("�Բ��𣬴˶��������ڣ�");
				}
				break;
			case 4:
				// 1������Ҫɾ���Ķ�����ţ���һ��ʼ��
				System.out.println("*******ɾ������********");
				System.out.print("������Ҫɾ���Ķ�����ţ�");
				int delId = input.nextInt();
				int delIndex = -1; // ɾ���������±�
				boolean isDelFind = false; // ��¼�Ƿ��ҵ��������� true���ҵ��� false��û�ҵ�
				// 2��ѭ��������������
				for (int i = 0; i < names.length; i++) {
					// �ҵ��˶�������ǩ�գ�ִ��ɾ������(�ȼ�¼Ҫɾ���Ķ������)
					// �ҵ��˶�������δǩ�գ���ʾ��Ϣ
					if (names[i] != null && states[i] == 1 && delId == i + 1) {
						delIndex = i;
						break;
					} else if (names[i] != null && states[i] == 1 && delId == i + 1) {
						System.out.println("��ѡ��Ķ���δǩ�գ�����ɾ����");
						break;
					}
				}
				// δ�ҵ��˶�������ʾ��Ϣ
				if (!isDelFind) {
					System.out.println("�Բ��𣬴�������û���ҵ���");
				}

				// ִ��ɾ������
				if (delIndex != -1) {
					// ɾ��������ѭ����λ ��
					// ��Ҫɾ����Ԫ�غ���һ����ʼ�����������һ��Ԫ��һ����ǰ�ƶ�һλ
					for (int i = delIndex + 1; i < names.length - 1; i++) {
						names[i - 1] = names[i];
						dishMegs[i - 1] = dishMegs[i];
						times[i - 1] = times[i];
						addresses[i - 1] = addresses[i];
						states[i - 1] = states[i];
					}
					// ���һλ���
					names[names.length - 1] = null;
					dishMegs[names.length - 1] = null;
					times[names.length - 1] = 0;
					addresses[names.length - 1] = null;
					states[names.length - 1] = 0;

				}
				break;
			case 5:
				// 5.��Ҫ����
				System.out.println("**********��Ҫ����*******");
				// 1,��ʾ�����޵Ĳ�Ʒ�б�
				System.out.println("���\t��Ʒ��\t����\t������");
				for (int j = 0; j < dishNames.length; j++) {
					String price = prices[j] + "Ԫ";
					String praise = praiseNums[j] + "��";
					System.out.println((j + 1) + "\t" + dishNames[j] + "\t" + price + "\t" + praise);
				}
				// 2������Ҫ���޵Ĳ�Ʒ���
				System.out.println("������Ҫ���޵Ĳ�Ʒ��ţ�");
				int dishId = input.nextInt();
				// 3������ŵĲ�Ʒ���޼�1
				praiseNums[dishId - 1]++;

				// 4����ʾ
				System.out.println("���޳ɹ�!");
				System.out.println(dishNames[dishId - 1] + " " + praiseNums[dishId - 1] + "��");
				break;
			case 6:
				// 6.�˳�ϵͳ
				break;
			default:
				break;
			}

			// ���û�����ı��Ϊ1-5֮�������ʱ���˳�ѭ�������򽫻���ʾ����0����
			if (choose < 1 || choose > 5) {
				break;
			} else {
				// ��ʾ����0����
				System.out.print("����0���أ�");
				num = input.nextInt();
			}

		} while (num == 0);
		System.out.println("ллʹ�ã���ӭ�´�ʹ�ã�");

	}

}
