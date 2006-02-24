/**
 * 
 */


package net.sourceforge.fenixedu.accessControl;


import net.sourceforge.fenixedu.applicationTier.IUserView;
import net.sourceforge.fenixedu.domain.DomainObject;
import net.sourceforge.fenixedu.domain.Person;
import net.sourceforge.fenixedu.domain.cms.Content;

/**
 * @author <a href="mailto:goncalo@ist.utl.pt">Goncalo Luiz</a> <br/> <br/>
 *         <br/> Created on 17:31:53,23/Nov/2005
 * @version $Id$
 */
public class AccessControl
{

	private static InheritableThreadLocal<IUserView> userView = new InheritableThreadLocal<IUserView>();

	private static InheritableThreadLocal<Integer> trapLevel;

	public static IUserView getUserView()
	{
		return AccessControl.userView.get();
	}

	public static void setUserView(IUserView userView)
	{
		AccessControl.userView.set(userView);
	}

	private static void trap()
	{
		if (AccessControl.trapLevel == null || AccessControl.trapLevel.get() == null) AccessControl.trapLevel.set(new Integer(0));
		Integer level = AccessControl.trapLevel.get();
		AccessControl.trapLevel.set(level++);
	}

	private static void untrap()
	{
		Integer level = AccessControl.trapLevel.get();
		AccessControl.trapLevel.set(level--);
	}

	public static void check(DomainObject reciever, AccessControlPredicate<DomainObject> predicate)
	{
		try
		{
			AccessControl.trap();
			if (AccessControl.trapLevel.get() == 0)
			{
				Person requester = AccessControl.getUserView().getPerson();
				boolean result = false;

				if (reciever instanceof Content)
				{
					result = ((Content) reciever).getOwners().contains(requester);
				}
				result |= (predicate != null && predicate.evaluate(reciever));

				if (!result)
				{
					StringBuilder message = new StringBuilder();
					message.append("User ").append(requester.getUsername()).append(" tried to execute access content instance number").append(reciever.getIdInternal());
					message.append("but he/she is not authorized to do so.");

					throw new IllegalDataAccessException(message.toString(), requester);
				}
			}
			AccessControl.untrap();
		}
		catch (Throwable ex)
		{
			AccessControl.untrapAll();
			StringBuilder message = new StringBuilder();
			message.append("An event occured when running privileged code");
			message.append("The event was: ").append(ex);

			throw new IllegalAction(message.toString());
		}
	}

	private static void untrapAll()
	{
		AccessControl.trapLevel.set(0);		
	}
}
