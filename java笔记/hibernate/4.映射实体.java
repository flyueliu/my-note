例：
	@Table("USERS")/*Table指定映射的表，name属性指定表名*/
	@SecondaryTable(name="USERS_PICTURES",pkJoinColumns=@PrimaryKeyJoinColumn(name="USER_ID")
	public class User implements Serializable{
		@Id
		@Column(name="USER_ID",nullable=false)
		/*
			1.Column映射列，name属性指定列的名称
			2.table属性，当使用@SecondaryTable注解把实体映射到多个表时，显式指定持久化的列属于哪个表
			3.unique,nullable,length
		*/
		protected Long userId;
		
		@Column(name="user_name",nullable=false)
		protected String userName;
		@Column(name="first_name",nullable=false,length=1)
		protected String firstName;
		@Column(name="last_name",nullable=false)
		protected String lastName;
		@Enumerated(EnumType.ORDINAL)//枚举列
		@Column(name="user_type",nullable=false)
		protected UserType userType;
		@Column(name="picture",table="user_picture")
		@Lob//Blob字段
		@Basic(fetch=FetchType.Lazy)//延迟加载
		protected byte[] picture;
		@Column(name="CREATION_DATE",nullable=false)
		@Temporal(TemporalType.DATE)
		protected Date createionDate;
		
		@Embedded
		protected Address address;
		
		public User(){}
	}
-----------------------------------------------------------------------------------------------------
映射一对一关系：
	1.使用@JoinColumn
	@Entity
	@Table(name="users")
	public class User{
		@Id
		@Column(name="user_id")
		protected String userId;
		...
		@OneToOne
		@JoinColumn(name="User_billing_id",referencedColumnName="billing_id",updatable=false)
		protected BillingInfo billingInfo;
	}
	@Entity
	@Table(name="billing_info")
	public class BillingInfo{
		@Id
		@Column(name="billing_info")//主键
		protected Long bilingId;
		...
	}
users表中的外键名称就将是"User_billing_id"(本表中的列名),referencedColumnName元素指定外键引用的主键 或唯一键的名称，如果没有指定referenceColumnName，则使用包含被引用实体身份的列（主键列）。
-----------------------------------------------------------------------------------------------------
映射一对多关系：
	@Entity
	@Table(name="items")
	public class Item{
		@Id
		@Column(name="item_id")
		protected Long itemId;
		....
		@OneToMany(mappedBy="item")
		protected Set<Bid> bids;
		...
	}
	@Entity
	@Table(name="BIDS")
	public class Bid{
		@Id
		@Column(name="bid_id")
		protected Long bidId;
		....
		@ManyToOne
		@JoinColumn(name="bid_item_id",referencedColumnName="item_id")
		protected Item item;
		....
	}
	
